package com.example.campusexchange.service;

import com.example.campusexchange.pojo.Post;
import com.example.campusexchange.pojo.PostPic;
import com.example.campusexchange.utils.Result;

import java.util.List;
import java.util.Map;

public interface PostService {
    Map getPosts(int pageNow, int pageSize);

    long uploadPost(Post post);
}
