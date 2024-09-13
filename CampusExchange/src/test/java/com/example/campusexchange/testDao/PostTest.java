package com.example.campusexchange.testDao;

import com.example.campusexchange.dao.PostDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.campusexchange.pojo.Post;

import java.util.Date;

@SpringBootTest
public class PostTest {
    @Autowired
    private PostDao postDao;
    @Test
    public void testInsertPostOne(){
        Post post = new Post();
        post.setPostTitle("saf");
        post.setPostVisitorUserId(100);
        post.setPostTextContent("sdgsgv");
        post.setPostPostingTime(new Date());

        int i = postDao.insertPostOne(post);
    }
}
