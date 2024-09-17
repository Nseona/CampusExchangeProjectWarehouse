package com.example.campusexchange.dao;

import com.example.campusexchange.pojo.VisitorUserCollect;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface VisitorUserCollectDao {

    @Insert("""
            INSERT INTO
            visitor_user_collect (user_id, post_id, collect_time)
            VALUES (#{userId}, #{postId}, #{collectTime})
            """)
    int insertVisitorUserCollectOne(VisitorUserCollect visitorUserCollect);

    @Select("select * from visitor_user_collect where user_id = #{userId}")
    @Results({
            @Result(property = "postId", column = "post_id"),
            @Result(property = "userId", column = "user_id"),
            @Result(property = "collectTime", column = "collect_time"),
            @Result(property = "visitorUserCollectId", column = "visitor_user_collect_id")
    })
    List<VisitorUserCollect> selectCollectAllByUserId(int userId);

    @Select("select * from visitor_user_collect where user_id = #{userId} and post_id = #{postId}")
    @Results({
            @Result(property = "postId", column = "post_id"),
            @Result(property = "userId", column = "user_id"),
            @Result(property = "collectTime", column = "collect_time"),
            @Result(property = "visitorUserCollectId", column = "visitor_user_collect_id")
    })
    VisitorUserCollect selectCollectByUserIdAndPostId(int userId, int postId);

    @Delete("DELETE FROM visitor_user_collect WHERE visitor_user_collect_id = #{visitorUserCollectId}")
    int deleteCollectByCollectId(int visitorUserCollectId);
}
