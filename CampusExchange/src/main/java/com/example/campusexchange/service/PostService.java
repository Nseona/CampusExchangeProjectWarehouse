package com.example.campusexchange.service;

import com.example.campusexchange.pojo.Post;
import com.example.campusexchange.pojo.PostPic;
import com.example.campusexchange.utils.Result;

public interface PostService {
    Result getPosts(int pageNow, int pageSize);

    long uploadPost(Post post);
}
