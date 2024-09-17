package com.example.campusexchange.testService;

import com.example.campusexchange.utils.Result;
import com.example.campusexchange.pojo.Post;
import com.example.campusexchange.service.PostService;
import com.github.pagehelper.PageInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest
public class PostServiceTest {
    @Autowired
    private PostService postService;
    @Test
    public void testGetPosts(){
        Map<String, Object> posts = postService.getPosts(1, 10);
        System.out.println(posts.get("postList"));
    }

    @Test
    public void testGetPostDetails(){
        Map<String, Object> postDetails = postService.getPostDetails(900);
        System.out.println(postDetails);

    }

    @Test
    public void testAddCollect(){
        postService.addCollect(182, 131);

//        postService.addCollect(2, 3);

    }

    @Test
    public void testRemoveCollect(){
        postService.removeCollect(182, 137);
    }
}
