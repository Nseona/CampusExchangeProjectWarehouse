package com.example.campusexchange.service;

import com.example.campusexchange.pojo.Post;

import java.util.List;
import java.util.Map;

public interface PostService {
    Map getPosts(int pageNow, int pageSize);
    long uploadPost(Post post);
    Map getPostsByTimeDesc(int pageNow, int pageSize);

    List<Map<String, Object>>  buildPostList(List<Post> posts);
}
