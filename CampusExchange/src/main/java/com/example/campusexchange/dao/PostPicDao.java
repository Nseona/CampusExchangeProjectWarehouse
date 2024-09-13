package com.example.campusexchange.dao;

import com.example.campusexchange.pojo.PostPic;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface PostPicDao {
    @Insert("INSERT INTO post_pic (post_id, path, upload_time) VALUES (#{postId}, #{path}, #{uploadTime})")
    int insertPostPicOne(PostPic postPic);
}
