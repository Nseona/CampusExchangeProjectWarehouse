package com.example.campusexchange.service.impl;

import com.example.campusexchange.dao.PostDao;
import com.example.campusexchange.dao.VisitorUserCollectDao;
import com.example.campusexchange.dao.VisitorUserDao;
import com.example.campusexchange.dao.VisitorUserLikeDao;
import com.example.campusexchange.pojo.Post;
import com.example.campusexchange.pojo.VisitorUserCollect;
import com.example.campusexchange.pojo.VisitorUserLike;
import com.example.campusexchange.utils.*;
import com.example.campusexchange.exception.ServiceException;
import com.example.campusexchange.pojo.VisitorUser;
import com.example.campusexchange.service.VisitorUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class VisitorUserServiceImpl implements VisitorUserService {
    @Autowired
    private VisitorUserDao visitorUserDao;

    @Autowired
    private VisitorUserCollectDao visitorUserCollectDao;

    @Autowired
    private VisitorUserLikeDao visitorUserLikeDao;

    @Autowired
    private VisitorUserServiceUtils visitorUserServiceUtils;

    @Autowired
    private PostServiceUtils postServiceUtils;

    @Autowired
    private PostDao postDao;

    @Override
    public Result verifyVisitorUser(VisitorUser visitorUser) {
        String userName = visitorUser.getUserName();
        String userPassword = visitorUser.getUserPassword();
        VisitorUser user = visitorUserDao.selectVisitorUserOneByName(userName);

        if (user == null){
            throw new ServiceException(StatusCode.UNAUTHORIZED, "用户不存在!");
        }

        if (!user.getUserPassword().equals(userPassword)){
            throw new ServiceException(StatusCode.UNAUTHORIZED, "密码错误!");
        }

        Map<String, String> load = new HashMap<>();
        load.put("userId", user.getUserId().toString());
        load.put("userName", user.getUserName());

        String token = JWTUtils.getToken(load);

        Map<String, String> data = new HashMap<>();
        data.put("token", token);
        data.put("userId", user.getUserId().toString());
        data.put("userName", user.getUserName());
        return new Result(StatusCode.OK, data, "登录成功!");
    }

    @Override
    public Result registeredVisitorUser(VisitorUser visitorUser) {
        String userName = visitorUser.getUserName();
        String userPassword = visitorUser.getUserPassword();

        String userNameRegex = "^[A-Za-z0-9_]+$";
        String userPasswordRegex = "^[A-Za-z0-9_]{8,}$";

        if (!userName.matches(userNameRegex)){
            throw new ServiceException(StatusCode.NON_STANDARD, "用户名格式错误, 仅包含字母数字下划线");
        }

        if (!userPassword.matches(userPasswordRegex)){
            throw new ServiceException(StatusCode.NON_STANDARD, "密码格式错误, 至少8位且仅包含字母数字下划线");
        }

        VisitorUser user = visitorUserDao.selectVisitorUserOneByName(userName);

        if (user != null){
            throw new ServiceException(StatusCode.NON_STANDARD, "用户名已经存在!");
        }

        int number = visitorUserDao.insertVisitorUserOne(visitorUser);

        if (number != 1){
            throw new ServiceException(StatusCode.UNKNOWN_SERVER_ERROR, "服务器繁忙...");
        }

        return new Result(StatusCode.OK, "注册成功!跳转至登录页");
    }

    @Override
    public Map<String, Object> getUserCollectList(int userId, int pageNow, int pageSize) {
        visitorUserServiceUtils.verifyVisitorUserExistByVisitorUserId(userId);

        PageHelper.startPage(pageNow, pageSize);
        List<VisitorUserCollect> visitorUserCollects = visitorUserCollectDao.selectCollectAllByUserId(userId);

        PageInfo<VisitorUserCollect> PageInfo = new PageInfo<>(visitorUserCollects);

        List<Map<String, Object>> collectList = new ArrayList<>();

        visitorUserCollects.forEach(item -> {
            Post post = postDao.selectPostOneByPostId(item.getPostId());
            Map<String, Object> map = postServiceUtils.buildPreviewPost(post);
            collectList.add(map);
        });

        HashMap<String, Object> data = new HashMap<>();
        data.put("collectList", collectList);
        data.put("isHasNextPage", PageInfo.isHasNextPage());

        return data;
    }

    @Override
    public Map<String, Object> getUserLikeList(int userId, int pageNow, int pageSize) {
        visitorUserServiceUtils.verifyVisitorUserExistByVisitorUserId(userId);

        PageHelper.startPage(pageNow, pageSize);
        List<VisitorUserLike> visitorUserLikes = visitorUserLikeDao.selectLikeAllByUserId(userId);

        PageInfo<VisitorUserLike> PageInfo = new PageInfo<>(visitorUserLikes);

        List<Map<String, Object>> likeList = new ArrayList<>();

        visitorUserLikes.forEach(item -> {
            Post post = postDao.selectPostOneByPostId(item.getPostId());
            Map<String, Object> map = postServiceUtils.buildPreviewPost(post);
            likeList.add(map);
        });

        HashMap<String, Object> data = new HashMap<>();
        data.put("likeList", likeList);
        data.put("isHasNextPage", PageInfo.isHasNextPage());

        return data;
    }

    @Override
    public Map<String, Object> getVisitorUserInfo(int userId) {
        VisitorUser user = visitorUserDao.selectVisitorUserOneById(userId);
        
        if (user == null){
            String message = String.format("用户 id = userId 不存在", userId);
            throw new ServiceException(StatusCode.NOT_FOUND, message);
        }

        HashMap<String, Object> map = new HashMap<>();

        map.put("userName", user.getUserName());
        map.put("userProfilePicture", null);

        return map;
    }
}
