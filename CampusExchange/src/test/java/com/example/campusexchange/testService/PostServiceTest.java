package com.example.campusexchange.testService;

import com.example.campusexchange.utils.Result;
import com.example.campusexchange.pojo.Post;
import com.example.campusexchange.service.PostService;
import com.github.pagehelper.PageInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PostServiceTest {
    @Autowired
    private PostService postService;
    @Test
    public void testGetPosts(){
        Result result = postService.getPosts(1, 10);
        List<Post> posts = (List<Post>) result.getData();

        for (Post datum : posts) {
            System.out.println(datum.getPostId() + " " + datum.getPostTitle());
        }

        PageInfo<Post> postPageInfo = new PageInfo<>(posts);

    }
}
