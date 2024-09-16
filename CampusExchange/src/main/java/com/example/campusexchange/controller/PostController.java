package com.example.campusexchange.controller;

import com.example.campusexchange.pojo.Post;
import com.example.campusexchange.pojo.PostPic;
import com.example.campusexchange.service.PostPicService;
import com.example.campusexchange.utils.FileUtils;
import com.example.campusexchange.utils.Result;
import com.example.campusexchange.service.PostService;
import com.example.campusexchange.utils.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@RestController
@RequestMapping("/post")
public class PostController {

    private static final Logger logger = LoggerFactory.getLogger(PostController.class);

    @Autowired
    private PostService postService;

    @Autowired
    private PostPicService postPicService;

    @Autowired
    private FileUtils fileUtils;

    @GetMapping("/posts")
    public Result posts(@RequestParam(name = "pageNow", required = true) int pageNow,
                        @RequestParam(name = "pageSize", required = true) int pageSize){

        Map data = postService.getPostsByTimeDesc(pageNow, pageSize);

        Result result = new Result();

        result.setStatusCode(StatusCode.OK);
        result.setData(data);

        if (data.isEmpty()){
            result.setMessage("没有更多了");
        } else {
            result.setMessage("查询成功!");
        }

        return result;
    }

    /**
     *
     * @param fileList 用户上传的图片文件
     * @param postTextContent 帖子内容
     * @param postVisitorUserId 用户id
     * @param postTitle 帖子标题
     *
     * 先将用户数据封装入实体类，存入数据库后取回自增的帖子 postId
     * 迭代文件列表 过程中同步的生成 PostPic 实体类， 并将 PostPic 集合插入数据库
     */
    @PutMapping
    public Result post(
                        @RequestParam(required = false) MultipartFile[] fileList,
                        @RequestParam String postTextContent,
                        @RequestParam int postVisitorUserId,
                        @RequestParam String postTitle){

        logger.info("id = " + postVisitorUserId + " 的用户尝试发布帖子");

        String currentTime = String.valueOf(System.currentTimeMillis());

        Post post = new Post();
        post.setPostVisitorUserId(postVisitorUserId);
        post.setPostTextContent(postTextContent);
        post.setPostTitle(postTitle);
        post.setPostPostingTime(new Date());

        long postId = postService.uploadPost(post);

        if (fileList != null){
            List<PostPic> postPicsList = new ArrayList<>();
            for (int i = 0; i < fileList.length; i++){
                String fileName = currentTime + i + "." + fileUtils.getFileSuffix(fileList[i]);

                fileUtils.fastenMultipart(fileList[i], fileName);

                PostPic postPic = new PostPic();
                postPic.setPostId((int) postId);
                postPic.setUploadTime(new Date());
                postPic.setPath(fileName);

                postPicsList.add(postPic);
            }
            postPicService.insertPostPicList(postPicsList);
        }

        logger.info("id = " + postVisitorUserId + " 发布了帖子, post_id = " + postId);

        return new Result(StatusCode.OK, "发布成功!");
    }
}
