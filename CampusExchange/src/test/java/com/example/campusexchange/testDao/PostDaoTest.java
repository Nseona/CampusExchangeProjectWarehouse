package com.example.campusexchange.testDao;

import com.example.campusexchange.dao.PostDao;
import com.example.campusexchange.pojo.Post;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
public class PostDaoTest {
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

        System.out.println(postDao.getLastInsertId());
    }

    @Test
    public void testSelectPostAll(){
        PageHelper.startPage(3, 1);
        List<Post> posts = postDao.selectPostAll();

        System.out.println("---------------");

        PageInfo<Post> postPageInfo = new PageInfo<>(posts);
        System.out.println(postPageInfo.isHasNextPage());

    }

    @Test
    public void testSelectPostAllByField(){
        PageHelper.startPage(2, 3);
        List<Post> posts = postDao.selectPostAllByField("ASC", "post_id");
        for (Post post : posts) {
            System.out.println(post.getPostId());
        }
    }


    @Test
    public void testSelectPostOneByPostId(){
        Post post = postDao.selectPostOneByPostId(900);
        System.out.println(post);
    }



}
