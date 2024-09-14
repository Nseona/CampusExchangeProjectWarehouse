package com.example.campusexchange.service;

import com.example.campusexchange.pojo.PostPic;

import java.util.List;

public interface PostPicService {
    void insertPostPicList(List<PostPic> postPicList);

    List<PostPic> getPostPics(int postId);

    PostPic getPostPic(int postId);
}
