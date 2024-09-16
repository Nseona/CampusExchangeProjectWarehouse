package com.example.campusexchange.dao;

import com.example.campusexchange.pojo.Post;
import org.apache.ibatis.annotations.*;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Mapper
@Validated
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

//
    /**
     *
     * @param mode 升序(ASC)或 降序(DESC)查询数据
     * @param field 根据哪个字段查询
     *
     * 注意 sql 语句中使用 $ 接收参数
     */

    @Select("""
                SELECT *
                FROM post
                ORDER BY ${field} ${mode}
            """)
    @Results({
            @Result(property = "postId", column = "post_id"),
            @Result(property = "postPostingTime", column = "post_posting_time"),
            @Result(property = "postTextContent", column = "post_text_content"),
            @Result(property = "postVisitorUserId", column = "post_visitor_user_id"),
            @Result(property = "postTitle", column = "post_title")
    })
    List<Post> selectPostAllByField(String mode, String field);

    @Select("""
                SELECT *
                FROM post
                ORDER BY ${field} ${mode}
                LIMIT ${offset}, ${count}
            """)
    @Results({
            @Result(property = "postId", column = "post_id"),
            @Result(property = "postPostingTime", column = "post_posting_time"),
            @Result(property = "postTextContent", column = "post_text_content"),
            @Result(property = "postVisitorUserId", column = "post_visitor_user_id"),
            @Result(property = "postTitle", column = "post_title")
    })
    List<Post> selectPostByFieldAndLimit(int offset, int count, String field, String mode);

//
    @Insert("""
            INSERT INTO
            post (post_posting_time, post_text_content, post_visitor_user_id, post_title)
            VALUES (#{postPostingTime}, #{postTextContent}, #{postVisitorUserId}, #{postTitle})
            """)
    int insertPostOne(Post post);

//
    /**
     *
     * @return 自动生成的主键值
     */
    @Select("SELECT LAST_INSERT_ID()")
    long getLastInsertId();
}
