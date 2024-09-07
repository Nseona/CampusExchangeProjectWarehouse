package com.example.campusexchange.dao;

import com.example.campusexchange.pojo.Post;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PostDao {
    @Select("select * from post")
    @Results({
            @Result(property = "postId", column = "post_id"),
            @Result(property = "postPostingTime", column = "post_posting_time"),
            @Result(property = "postTextContent", column = "post_text_content"),
            @Result(property = "postVisitorUserId", column = "post_visitor_user_id"),
            @Result(property = "postTitle", column = "post_title")
    })
    List<Post> selectPostAll();
}
