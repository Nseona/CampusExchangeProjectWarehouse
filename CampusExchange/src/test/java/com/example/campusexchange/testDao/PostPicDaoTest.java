package com.example.campusexchange.testDao;

import com.example.campusexchange.dao.PostPicDao;
import com.example.campusexchange.pojo.PostPic;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;


@SpringBootTest
public class PostPicDaoTest {
    @Autowired
    private PostPicDao postPicDao;
    @Test
    public void testInsertPostPicOne(){
        PostPic postPic = new PostPic();

        postPic.setPostId(1);
        postPic.setPath("acd");
        postPic.setPostPicId(2);
        postPic.setUploadTime(new Date());

        int i = postPicDao.insertPostPicOne(postPic);
        System.out.println(i);
    }

    @Test
    public void testSelectPostPicAllByPostId(){
        List<PostPic> postPics = postPicDao.selectPostPicAllByPostId(131);

        for (PostPic postPic : postPics) {
            System.out.println(postPic);
        }

    }
}
