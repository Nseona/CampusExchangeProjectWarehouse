package com.example.campusexchange.utils;

import com.example.campusexchange.dao.PostDao;
import com.example.campusexchange.pojo.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PostDaoPageHelper {
    @Autowired
    private PostDao postDao;

    public List<Post> selectPostAllByField(String mode, String field, int pageNow, int pageSize){
        List<Post> posts = postDao.selectPostByFieldAndLimit((pageNow - 1) * pageSize, pageSize, field, mode);
        return posts;
    }

    public List<Post> selectPostAll(int pageNow, int pageSize){
        String mode = "ASC";
        String field = "post_id";

        return this.selectPostAllByField(mode, field, pageNow, pageSize);
    }

}
