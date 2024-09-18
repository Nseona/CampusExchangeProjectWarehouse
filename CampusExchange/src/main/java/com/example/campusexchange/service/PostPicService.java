package com.example.campusexchange.service;

import com.example.campusexchange.pojo.PostPic;

import java.util.List;
import java.util.Map;

public interface PostPicService {
    void insertPostPicList(List<PostPic> postPicList);

    List<String> getPostPicBase64List(int postId);

    String getPostPicBase64(int postId);
}
