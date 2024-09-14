package com.example.campusexchange.testService;

import com.example.campusexchange.pojo.PostPic;
import com.example.campusexchange.service.PostPicService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest
public class PostPicServiceTest {
    @Autowired
    private PostPicService postPicService;

    @Test
    public void testInsertPostPicList(){
        List<PostPic> postPicsList = new ArrayList<>();
        for (int i = 0; i < 3; i++){
            PostPic postPic = new PostPic();
            postPic.setUploadTime(new Date());
            postPic.setPostId(i + 1000);
            postPic.setPath("dsf");

            postPicsList.add(postPic);
        }

        postPicService.insertPostPicList(postPicsList);
    }

    @Test
    public void testGetPostPics(){
        List<PostPic> postPics = postPicService.getPostPics(131);
        for (PostPic postPic : postPics) {
            System.out.println(postPics);
        }

    }

}
