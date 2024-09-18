package com.example.campusexchange.service.impl;

import com.example.campusexchange.dao.PostPicDao;
import com.example.campusexchange.pojo.PostPic;
import com.example.campusexchange.service.PostPicService;
import com.example.campusexchange.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PostPicServiceImpl implements PostPicService {
    @Autowired
    private PostPicDao postPicDao;

    @Autowired
    private FileUtils fileUtils;

    @Override
    public void insertPostPicList(List<PostPic> postPicList) {
        for (PostPic postPic : postPicList) {
            postPicDao.insertPostPicOne(postPic);
        }
    }

    @Override
    public List<String> getPostPicBase64List(int postId) {
        List<PostPic> postPics = postPicDao.selectPostPicAllByPostId(postId);

        List<String> base64List = fileUtils.toBase64(postPics);

        return base64List;
    }

    @Override
    public String getPostPicBase64(int postId) {
        List<String> postPicBase64List = this.getPostPicBase64List(postId);

        if (postPicBase64List.isEmpty()){
            return null;
        } else {
            return postPicBase64List.get(0);
        }
    }
}
