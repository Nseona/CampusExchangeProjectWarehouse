package com.example.campusexchange.service.impl;

import com.example.campusexchange.dao.PostDao;
import com.example.campusexchange.dao.VisitorUserDao;
import com.example.campusexchange.dto.Dto;
import com.example.campusexchange.dto.PostDto;
import com.example.campusexchange.pojo.Post;
import com.example.campusexchange.pojo.VisitorUser;
import com.example.campusexchange.service.PostService;
import com.example.campusexchange.statusCode.StatusCode;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageRowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostDao postDao;

    @Autowired
    private VisitorUserDao visitorUserDao;

    /**
     *
     * @param pageNow 需要查询的页码
     * @param pageSize 每页显示的记录数量
     *
     * PageHelper.startPage() 的使用 针对下一次查询，之后就会失效
     * 使用 PageInfo 封装查询结果后 可以获得分页信息
     * 查询出 posts 后 将其遍历 把对应的作者姓名查询出来
     * 利用 PostDto 封装前端需要的数据
     */

    @Override
    public Dto getPosts(int pageNow, int pageSize) {
        PageHelper.startPage(pageNow, pageSize);
        List<Post> posts = postDao.selectPostAll();

        List<PostDto> postDtoList = new ArrayList<>();

        posts.forEach(post -> {
            Integer postVisitorUserId = post.getPostVisitorUserId();
            VisitorUser visitorUser = visitorUserDao.selectVisitorUserOneById(postVisitorUserId);

            PostDto postDto = new PostDto();

            postDto.setPostId(post.getPostId());
            postDto.setPostTextContent(post.getPostTextContent());
            postDto.setPostTitle(post.getPostTitle());
            postDto.setPostPostingTime(post.getPostPostingTime());
            postDto.setUserName(visitorUser.getUserName());
            postDto.setPostVisitorUserId(visitorUser.getUserId());

            postDtoList.add(postDto);
        });

        Dto dto = new Dto();
        dto.setMessage("查询成功!");
        dto.setStatusCode(StatusCode.OK);
        dto.setData(postDtoList);

        return dto;
    }
}
