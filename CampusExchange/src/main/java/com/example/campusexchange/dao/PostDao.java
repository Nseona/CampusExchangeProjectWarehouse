package com.example.campusexchange.dao;

import com.example.campusexchange.pojo.Post;
import com.example.campusexchange.pojo.PostPic;
import org.apache.ibatis.annotations.*;

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

    @Insert("INSERT INTO " +
            "post (post_posting_time, post_text_content, post_visitor_user_id, post_title) " +
            "VALUES (#{postPostingTime}, #{postTextContent}, #{postVisitorUserId}, #{postTitle})")
    int insertPostOne(Post post);


    /**
     *
     * @return 自动生成的主键值
     */
    @Select("SELECT LAST_INSERT_ID()")
    long getLastInsertId();
}
