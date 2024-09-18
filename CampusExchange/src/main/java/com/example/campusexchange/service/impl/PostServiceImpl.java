package com.example.campusexchange.service.impl;

import com.example.campusexchange.dao.*;
import com.example.campusexchange.exception.MapperException;
import com.example.campusexchange.exception.ServiceException;
import com.example.campusexchange.pojo.VisitorUser;
import com.example.campusexchange.pojo.VisitorUserCollect;
import com.example.campusexchange.pojo.VisitorUserLike;
import com.example.campusexchange.service.PostPicService;
import com.example.campusexchange.service.VisitorUserCollectService;
import com.example.campusexchange.service.VisitorUserLikeService;
import com.example.campusexchange.utils.PostServiceUtils;
import com.example.campusexchange.pojo.Post;
import com.example.campusexchange.service.PostService;
import com.example.campusexchange.utils.StatusCode;
import com.example.campusexchange.utils.VisitorUserServiceUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostDao postDao;

    @Autowired
    private VisitorUserDao visitorUserDao;

    @Autowired
    private PostPicDao postPicDao;

    @Autowired
    private VisitorUserLikeDao visitorUserLikeDao;

    @Autowired
    private PostServiceUtils postServiceUtils;

    @Autowired
    private VisitorUserServiceUtils visitorUserServiceUtils;

    @Autowired
    private VisitorUserCollectDao visitorUserCollectDao;

    @Autowired
    private PostPicService postPicService;

    @Autowired
    private VisitorUserCollectService visitorUserCollectService;

    @Autowired
    private VisitorUserLikeService visitorUserLikeService;

    /**
     *
     * @param pageNow 需要查询的页码
     * @param pageSize 每页显示的记录数量
     *
     * PageHelper.startPage() 的使用 针对下一次查询，之后就会失效
     * 使用 PageInfo 封装查询结果后 可以获得分页信息
     * 查询出 posts 后 将其遍历 把对应的作者姓名查询出来
     * 利用 Map 封装前端需要的数据
     */

    @Override
    public Map getPosts(int pageNow, int pageSize) {
        PageHelper.startPage(pageNow, pageSize);

        List<Post> posts = postDao.selectPostAll();

        PageInfo<Post> postPageInfo = new PageInfo<>(posts);

        List<Map<String, Object>> postList = postServiceUtils.buildPreviewPostList(posts);

        Map<String, Object> data = new HashMap<>();

        data.put("postList", postList);
        data.put("isHasNextPage", postPageInfo.isHasNextPage());

        return data;
    }

    @Override
    public Map<String, Object> getPostDetails(int postId) {
        Post post = postDao.selectPostOneByPostId(postId);

        if (post == null){
            throw new ServiceException(StatusCode.NOT_FOUND, "帖子 postId = " + postId + " 不存在");
        }

        Integer userId = post.getPostVisitorUserId();
        VisitorUser visitorUser = visitorUserDao.selectVisitorUserOneById(userId);

        List<String> postPicBase64List = postPicService.getPostPicBase64List(postId);

        Map<String, Object> map = new HashMap<>();
        map.put("postId", postId);
        map.put("postTextContent", post.getPostTextContent());
        map.put("postTitle", post.getPostTitle());
        map.put("postPostingTime", post.getPostPostingTime());
        map.put("userName", visitorUser.getUserName());
        map.put("base64List", postPicBase64List);
        map.put("likeState", visitorUserLikeService.userWhetherOrNotSelect(userId, postId));
        map.put("collectState", visitorUserCollectService.userWhetherOrNotSelect(userId, postId));

        return map;
    }

    /**
     * @param post
     * @return 插入 post 成功时返回自动设置的 post 主键值
     */
    @Override
    public long uploadPost(Post post) {
        postDao.insertPostOne(post);
        return postDao.getLastInsertId();
    }

    @Override
    public Map getPreviewPostsByTimeDesc(int pageNow, int pageSize) {
        PageHelper.startPage(pageNow, pageSize);
        List<Post> posts = postDao.selectPostAllByField("DESC", "post_posting_time");
        List<Map<String, Object>> postList = postServiceUtils.buildPreviewPostList(posts);
        PageInfo<Post> postPageInfo = new PageInfo<>(posts);

        Map<String, Object> data = new HashMap<>();

        data.put("postList", postList);
        data.put("isHasNextPage", postPageInfo.isHasNextPage());

        return data;
    }

    @Override
    public void addCollect(int userId, int postId) {
        postServiceUtils.verifyPostExistByPostId(postId);
        visitorUserServiceUtils.verifyVisitorUserExistByVisitorUserId(userId);

        VisitorUserCollect visitorUserCollect = visitorUserCollectDao.selectCollectByUserIdAndPostId(userId, postId);

        if (visitorUserCollect != null){
            throw new ServiceException(StatusCode.NON_STANDARD, String.format("收藏记录 userId = %d, postId = %d 已存在, 无法再次添加", userId, postId));
        }

        VisitorUserCollect vuc = new VisitorUserCollect();
        vuc.setPostId(postId);
        vuc.setUserId(userId);
        vuc.setCollectTime(new Date());

        int effect = visitorUserCollectDao.insertVisitorUserCollectOne(vuc);

        if (effect != 1){
            String message = String.format("向用户收藏表插入数据时出现异常 userId = %d, postId = %d", userId, postId);
            throw new MapperException(StatusCode.INTERNAL_ERROR, message);
        }
    }

    @Override
    public void removeCollect(int userId, int postId) {
        postServiceUtils.verifyPostExistByPostId(postId);
        visitorUserServiceUtils.verifyVisitorUserExistByVisitorUserId(userId);

        VisitorUserCollect visitorUserCollect = visitorUserCollectDao.selectCollectByUserIdAndPostId(userId, postId);

        if (visitorUserCollect == null){
            throw new ServiceException(StatusCode.NON_STANDARD, String.format("收藏记录 userId = %d, postId = %d 不存在, 无法移除", userId, postId));
        }

        Integer visitorUserCollectId = visitorUserCollect.getVisitorUserCollectId();

        int effect = visitorUserCollectDao.deleteCollectByCollectId(visitorUserCollectId);

        if (effect != 1){
            String message = String.format("向用户收藏表删除数据时出现异常 userId = %d, postId = %d", userId, postId);
            throw new MapperException(StatusCode.INTERNAL_ERROR, message);
        }
    }

    @Override
    public void addLike(int userId, int postId) {
        postServiceUtils.verifyPostExistByPostId(postId);
        visitorUserServiceUtils.verifyVisitorUserExistByVisitorUserId(userId);

        VisitorUserLike visitorUserLike = visitorUserLikeDao.selectLikeByUserIdAndPostId(userId, postId);

        if (visitorUserLike != null){
            throw new ServiceException(StatusCode.NON_STANDARD, String.format("点赞记录 userId = %d, postId = %d 已存在, 无法再次添加", userId, postId));
        }

        VisitorUserLike vul = new VisitorUserLike();
        vul.setPostId(postId);
        vul.setUserId(userId);
        vul.setLikeTime(new Date());

        int effect = visitorUserLikeDao.insertVisitorUserLikeOne(vul);

        if (effect != 1){
            String message = String.format("向用户点赞表插入数据时出现异常 userId = %d, postId = %d", userId, postId);
            throw new MapperException(StatusCode.INTERNAL_ERROR, message);
        }
    }

    @Override
    public void removeLike(int userId, int postId) {
        postServiceUtils.verifyPostExistByPostId(postId);
        visitorUserServiceUtils.verifyVisitorUserExistByVisitorUserId(userId);

        VisitorUserLike visitorUserLike = visitorUserLikeDao.selectLikeByUserIdAndPostId(userId, postId);

        if (visitorUserLike == null){
            throw new ServiceException(StatusCode.NON_STANDARD, String.format("点赞记录 userId = %d, postId = %d 不存在, 无法移除", userId, postId));
        }

        Integer visitorUserLikeId = visitorUserLike.getVisitorUserLikeId();

        int effect = visitorUserLikeDao.deleteLikeByLikeId(visitorUserLikeId);

        if (effect != 1){
            String message = String.format("向用户点赞表删除数据时出现异常 userId = %d, postId = %d", userId, postId);
            throw new MapperException(StatusCode.INTERNAL_ERROR, message);
        }
    }


}
