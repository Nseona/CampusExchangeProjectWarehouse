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
        List<Map<String, Object>> posts = postService.getPosts(1, 10);


    }
}
