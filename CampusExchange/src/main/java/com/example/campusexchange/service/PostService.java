package com.example.campusexchange.service;

import com.example.campusexchange.dto.Dto;

public interface PostService {
    Dto getPosts(int pageNow, int pageSize);
}
