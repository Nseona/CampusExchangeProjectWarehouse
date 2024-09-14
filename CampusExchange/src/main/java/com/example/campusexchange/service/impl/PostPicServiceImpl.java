package com.example.campusexchange.service.impl;

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



}
