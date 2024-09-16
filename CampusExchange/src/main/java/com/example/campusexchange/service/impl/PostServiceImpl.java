package com.example.campusexchange.service.impl;

import com.example.campusexchange.controller.PostController;
import com.example.campusexchange.dao.PostDao;
import com.example.campusexchange.dao.PostPicDao;
import com.example.campusexchange.dao.VisitorUserDao;
import com.example.campusexchange.exception.ServiceException;
import com.example.campusexchange.pojo.PostPic;
import com.example.campusexchange.utils.PostServiceUtils;
import com.example.campusexchange.utils.Result;
import com.example.campusexchange.pojo.Post;
import com.example.campusexchange.pojo.VisitorUser;
import com.example.campusexchange.service.PostService;
import com.example.campusexchange.utils.StatusCode;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostDao postDao;

    @Autowired
    private VisitorUserDao visitorUserDao;

    @Autowired
    private PostPicDao postPicDao;

    @Autowired
    private PostServiceUtils postServiceUtils;

    /**
     *
     * @param pageNow 需要查询的页码
     * @param pageSize 每页显示的记录数量
     *
     * PageHelper.startPage() 的使用 针对下一次查询，之后就会失效
     * 使用 PageInfo 封装查询结果后 可以获得分页信息
     * 查询出 posts 后 将其遍历 把对应的作者姓名查询出来
     * 利用 Map 封装前端需要的数据
     */

    @Override
    public Map getPosts(int pageNow, int pageSize) {
        PageHelper.startPage(pageNow, pageSize);

        List<Post> posts = postDao.selectPostAll();

        PageInfo<Post> postPageInfo = new PageInfo<>(posts);

        List<Map<String, Object>> postList = postServiceUtils.buildPostList(posts);

        Map<String, Object> data = new HashMap<>();

        data.put("postList", postList);
        data.put("isHasNextPage", postPageInfo.isHasNextPage());

        return data;
    }

    @Override
    public Map<String, Object> getPostDetails(int postId) {
        Post post = postDao.selectPostOneByPostId(postId);

        if (post == null){
            throw new ServiceException(StatusCode.notFound, "该帖子不存在");
        }

        return postServiceUtils.buildPost(post);
    }

    /**
     * @param post
     * @return 插入 post 成功时返回自动设置的 post 主键值
     */
    @Override
    public long uploadPost(Post post) {
        postDao.insertPostOne(post);
        return postDao.getLastInsertId();
    }

    @Override
    public Map getPostsByTimeDesc(int pageNow, int pageSize) {
        PageHelper.startPage(pageNow, pageSize);
        List<Post> posts = postDao.selectPostAllByField("DESC", "post_posting_time");
        List<Map<String, Object>> postList = postServiceUtils.buildPostList(posts);
        PageInfo<Post> postPageInfo = new PageInfo<>(posts);

        Map<String, Object> data = new HashMap<>();

        data.put("postList", postList);
        data.put("isHasNextPage", postPageInfo.isHasNextPage());

        return data;
    }


}
