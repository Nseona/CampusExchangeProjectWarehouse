package com.example.campusexchange.service.impl;

import com.example.campusexchange.dao.PostDao;
import com.example.campusexchange.dao.PostPicDao;
import com.example.campusexchange.dao.VisitorUserDao;
import com.example.campusexchange.pojo.PostPic;
import com.example.campusexchange.utils.Result;
import com.example.campusexchange.pojo.Post;
import com.example.campusexchange.pojo.VisitorUser;
import com.example.campusexchange.service.PostService;
import com.example.campusexchange.utils.StatusCode;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostDao postDao;

    @Autowired
    private VisitorUserDao visitorUserDao;

    @Autowired
    private PostPicDao postPicDao;

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
    public Result getPosts(int pageNow, int pageSize) {
        PageHelper.startPage(pageNow, pageSize);
        List<Post> posts = postDao.selectPostAll();

        List<Map<String, Object>> data = new ArrayList<>();

        posts.forEach(post -> {
            Integer postVisitorUserId = post.getPostVisitorUserId();
            VisitorUser visitorUser = visitorUserDao.selectVisitorUserOneById(postVisitorUserId);

            Map<String, Object> item = new HashMap<>();

            item.put("postId", post.getPostId());
            item.put("postTextContent", post.getPostTextContent());
            item.put("postTitle", post.getPostTitle());
            item.put("postPostingTime", post.getPostPostingTime());
            item.put("userName", visitorUser.getUserName());
            item.put("postVisitorUserId", visitorUser.getUserId());

            data.add(item);
        });

        Result result = new Result();
        result.setMessage("查询成功!");
        result.setStatusCode(StatusCode.OK);
        result.setData(data);

        return result;
    }

    @Override
    public Result uploadPost(Post post, PostPic postPic) {
        int i = postPicDao.insertPostPicOne(postPic);

        int i1 = postDao.insertPostOne(post);

        return null;
    }
}
