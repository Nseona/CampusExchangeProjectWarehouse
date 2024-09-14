package com.example.campusexchange.dao;

import com.example.campusexchange.pojo.Post;
import com.example.campusexchange.pojo.PostPic;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PostPicDao {
    @Insert("INSERT INTO post_pic (post_id, path, upload_time) VALUES (#{postId}, #{path}, #{uploadTime})")
    int insertPostPicOne(PostPic postPic);

    @Select("select * from post_pic where post_id = #{postId}")
    @Results({
            @Result(property = "postPicId", column = "post_pic_id"),
            @Result(property = "postId", column = "post_id"),
            @Result(property = "path", column = "path"),
            @Result(property = "uploadTime", column = "upload_time"),
    })
    List<PostPic> selectPostPicAllByPostId(int postId);
}
