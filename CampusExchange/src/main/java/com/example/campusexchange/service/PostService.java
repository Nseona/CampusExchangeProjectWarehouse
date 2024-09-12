package com.example.campusexchange.service;

import com.example.campusexchange.utils.Result;

public interface PostService {
    Result getPosts(int pageNow, int pageSize);
}
