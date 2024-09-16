package com.example.campusexchange;

import com.example.campusexchange.pojo.Post;
import com.example.campusexchange.utils.PostDaoPageHelper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class TestPostDaoPageHelper{
    @Autowired
    private PostDaoPageHelper postDaoPageHelper;

    @Test
    public void testSelectPostAll(){
        List<Post> posts = postDaoPageHelper.selectPostAll(4, 2);
        if (posts.isEmpty()){
            System.out.println("!!");
        }

        for (Post post : posts) {
            System.out.println(post);
        }

    }

}
