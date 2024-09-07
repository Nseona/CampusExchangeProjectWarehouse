package com.example.campusexchange.service.impl;

import com.example.campusexchange.dao.PostDao;
import com.example.campusexchange.dto.Dto;
import com.example.campusexchange.pojo.Post;
import com.example.campusexchange.service.PostService;
import com.example.campusexchange.statusCode.StatusCode;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageRowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostDao postDao;

    /**
     *
     * @param pageNow 需要查询的页码
     * @param pageSize 每页显示的记录数量
     *
     * PageHelper.startPage() 的使用 针对下一次查询，之后就会失效
     * 使用 PageInfo 封装查询结果后 可以获得分页信息
     */

    @Override
    public Dto getPosts(int pageNow, int pageSize) {
        PageHelper.startPage(pageNow, pageSize);
        List<Post> posts = postDao.selectPostAll();

        Dto dto = new Dto();
        dto.setMessage("查询成功!");
        dto.setStatusCode(StatusCode.OK);
        dto.setData(posts);

        return dto;
    }
}
