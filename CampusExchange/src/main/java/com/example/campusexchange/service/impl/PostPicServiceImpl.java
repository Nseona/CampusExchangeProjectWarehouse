package com.example.campusexchange.service.impl;

import ch.qos.logback.classic.spi.EventArgUtil;
import com.example.campusexchange.dao.PostPicDao;
import com.example.campusexchange.pojo.PostPic;
import com.example.campusexchange.service.PostPicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PostPicServiceImpl implements PostPicService {
    @Autowired
    private PostPicDao postPicDao;

    @Override
    public void insertPostPicList(List<PostPic> postPicList) {
        for (PostPic postPic : postPicList) {
            postPicDao.insertPostPicOne(postPic);
        }
    }

    @Override
    public List<PostPic> getPostPics(int postId) {
        List<PostPic> postPics = postPicDao.selectPostPicAllByPostId(postId);
        return postPics;
    }

    @Override
    public PostPic getPostPic(int postId) {
        List<PostPic> postPics = this.getPostPics(postId);
        if (postPics.isEmpty()){
            return null;
        }
        return postPics.get(0);
    }


}
