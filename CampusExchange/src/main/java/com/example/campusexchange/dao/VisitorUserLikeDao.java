package com.example.campusexchange.dao;

import com.example.campusexchange.pojo.VisitorUserCollect;
import com.example.campusexchange.pojo.VisitorUserLike;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface VisitorUserLikeDao {

    @Insert("""
            INSERT INTO
            visitor_user_like (user_id, post_id, like_time)
            VALUES (#{userId}, #{postId}, #{likeTime})
            """)
    int insertVisitorUserLikeOne(VisitorUserLike visitorUserLike);


    @Select("select * from visitor_user_like where user_id = #{userId}")
    @Results({
            @Result(property = "postId", column = "post_id"),
            @Result(property = "userId", column = "user_id"),
            @Result(property = "likeTime", column = "like_time"),
            @Result(property = "visitorUserLikeId", column = "visitor_user_like_id")
    })
    List<VisitorUserLike> selectLikeAllByUserId(int userId);

    @Select("select * from visitor_user_like where user_id = #{userId} and post_id = #{postId}")
    @Results({
            @Result(property = "postId", column = "post_id"),
            @Result(property = "userId", column = "user_id"),
            @Result(property = "likeTime", column = "like_time"),
            @Result(property = "visitorUserLikeId", column = "visitor_user_like_id")
    })
    VisitorUserLike selectLikeByUserIdAndPostId(int userId, int postId);

    @Delete("DELETE FROM visitor_user_like WHERE visitor_user_like_id = #{visitorUserLikeId}")
    int deleteLikeByLikeId(int visitorUserLikeId);
}
