package com.example.campusexchange.service;

import com.example.campusexchange.pojo.Post;

import java.util.Map;

public interface PostService {
    Map<String, Object> getPosts(int pageNow, int pageSize);
    Map<String, Object> getPostDetails(int postId);
    long uploadPost(Post post);
    Map getPreviewPostsByTimeDesc(int pageNow, int pageSize);
    void addCollect(int userId, int postId);
    void removeCollect(int userId, int postId);
    void addLike(int userId, int postId);
    void removeLike(int userId, int postId);
}
