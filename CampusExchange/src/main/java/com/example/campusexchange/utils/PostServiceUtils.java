package com.example.campusexchange.utils;

import com.example.campusexchange.dao.PostDao;
import com.example.campusexchange.dao.VisitorUserCollectDao;
import com.example.campusexchange.dao.VisitorUserDao;
import com.example.campusexchange.exception.ServiceException;
import com.example.campusexchange.pojo.Post;
import com.example.campusexchange.pojo.VisitorUser;
import com.example.campusexchange.service.PostPicService;
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

    @Autowired
    private PostDao postDao;

    @Autowired
    private PostPicService postPicService;

    public List<Map<String, Object>> buildPreviewPostList(List<Post> posts){
        List<Map<String, Object>> postList = new ArrayList<>();

        posts.forEach(post -> {
            postList.add(this.buildPreviewPost(post));
        });

        return postList;
    }
    public Map<String, Object> buildPreviewPost(Post post){

        if (post == null){
            throw new ServiceException(StatusCode.NOT_FOUND, "该帖子不存在");
        }

        Integer userId = post.getPostVisitorUserId();
        VisitorUser visitorUser = visitorUserDao.selectVisitorUserOneById(userId);

        Integer postId = post.getPostId();
        String postPicBase64 = postPicService.getPostPicBase64(postId);

        Map<String, Object> map = new HashMap<>();
        map.put("postId", post.getPostId());
        map.put("postTextContent", post.getPostTextContent());
        map.put("postTitle", post.getPostTitle());
        map.put("userName", visitorUser.getUserName());
        map.put("base64", postPicBase64);

        return map;
    }

//    public Map<String, Object> buildDetailsPost(int postId){
//
//        Post post = postDao.selectPostOneByPostId(postId);
//
//        if (post == null){
//            throw new ServiceException(StatusCode.NOT_FOUND, "帖子 postId = " + postId + " 不存在");
//        }
//
//        if (post == null){
//            throw new ServiceException(StatusCode.NOT_FOUND, "该帖子不存在");
//        }
//
//        Integer postId = post.getPostId();
//
//        Integer userId = post.getPostVisitorUserId();
//        VisitorUser visitorUser = visitorUserDao.selectVisitorUserOneById(userId);
//
//        List<String> postPicBase64List = postPicService.getPostPicBase64List(postId);
//
//        Map<String, Object> map = new HashMap<>();
//        map.put("postId", postId);
//        map.put("postTextContent", post.getPostTextContent());
//        map.put("postTitle", post.getPostTitle());
//        map.put("postPostingTime", post.getPostPostingTime());
//        map.put("userName", visitorUser.getUserName());
//        map.put("base64List", postPicBase64List);
//
//        return map;
//    }

    public void verifyPostExistByPostId(int postId){
        Post post = postDao.selectPostOneByPostId(postId);
        if (post == null){
            throw new ServiceException(StatusCode.NON_STANDARD, String.format("操作的帖子 postId = %d 不存在!", postId));
        }
    }

}
