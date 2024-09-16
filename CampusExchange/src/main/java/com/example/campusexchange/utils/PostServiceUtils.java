package com.example.campusexchange.utils;

import com.example.campusexchange.dao.VisitorUserDao;
import com.example.campusexchange.exception.ServiceException;
import com.example.campusexchange.pojo.Post;
import com.example.campusexchange.pojo.VisitorUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class PostServiceUtils {
    @Autowired
    private VisitorUserDao visitorUserDao;
    public List<Map<String, Object>> buildPostList(List<Post> posts){
        List<Map<String, Object>> postList = new ArrayList<>();

        posts.forEach(post -> {
            postList.add(this.buildPost(post));
        });

        return postList;
    }
    public Map<String, Object> buildPost(Post post){

        if (post == null){
            throw new ServiceException(StatusCode.notFound, "该帖子不存在");
        }

        Integer userId = post.getPostVisitorUserId();
        VisitorUser visitorUser = visitorUserDao.selectVisitorUserOneById(userId);

        Map<String, Object> map = new HashMap<>();

        map.put("postId", post.getPostId());
        map.put("postTextContent", post.getPostTextContent());
        map.put("postTitle", post.getPostTitle());
        map.put("postPostingTime", post.getPostPostingTime());
        map.put("userName", visitorUser.getUserName());
        map.put("postVisitorUserId", visitorUser.getUserId());

        return map;
    }
}
