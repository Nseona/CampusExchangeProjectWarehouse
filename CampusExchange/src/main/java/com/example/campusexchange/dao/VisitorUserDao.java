package com.example.campusexchange.dao;

import com.example.campusexchange.pojo.VisitorUser;
import org.apache.ibatis.annotations.*;

@Mapper
public interface VisitorUserDao {
    @Select("select * from visitor_user where user_name = #{userName}")
    @Results({
            @Result(property = "userId", column = "user_id"),
            @Result(property = "userName", column = "user_name"),
            @Result(property = "userPassword", column = "user_password")
    })
    VisitorUser selectVisitorUserOneByName(@Param("userName") String userName);

    @Select("select * from visitor_user where user_id = #{userId}")
    @Results({
            @Result(property = "userId", column = "user_id"),
            @Result(property = "userName", column = "user_name"),
            @Result(property = "userPassword", column = "user_password")
    })
    VisitorUser selectVisitorUserOneById(@Param("userId") int userId);

    @Insert("INSERT INTO visitor_user (user_name, user_password) VALUES (#{userName}, #{userPassword})")
    int insertVisitorUserOne(VisitorUser visitorUser);
}
