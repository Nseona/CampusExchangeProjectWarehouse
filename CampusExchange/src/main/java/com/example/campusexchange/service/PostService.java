package com.example.campusexchange.service;

import com.example.campusexchange.pojo.Post;

import java.util.List;
import java.util.Map;

public interface PostService {
    Map<String, Object> getPosts(int pageNow, int pageSize);
    Map<String, Object> getPostDetails(int postId);
    long uploadPost(Post post);
    Map getPostsByTimeDesc(int pageNow, int pageSize);

}
