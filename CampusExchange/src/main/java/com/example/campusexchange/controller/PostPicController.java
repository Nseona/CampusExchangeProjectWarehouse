package com.example.campusexchange.controller;

import com.example.campusexchange.pojo.PostPic;
import com.example.campusexchange.service.PostPicService;
import com.example.campusexchange.utils.FileUtils;
import com.example.campusexchange.utils.Result;
import com.example.campusexchange.utils.StatusCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/postPic")
public class PostPicController {
    private static final Logger logger = LoggerFactory.getLogger(PostPicController.class);

    @Autowired
    private PostPicService postPicService;

    @Autowired
    private FileUtils fileUtils;

    @GetMapping
    public Result postPics(@RequestParam int postId){

        List<PostPic> postPics = postPicService.getPostPics(postId);

        if (postPics.isEmpty()){
            return new Result(StatusCode.NOT_CONTENT, null, "该帖子无图片");
        }

        List<String> base64List = fileUtils.toBase64(postPics);
        Map<String, List<String>> map = new HashMap<>();
        map.put("base64List", base64List);

        return new Result(StatusCode.OK, map, "获取帖子图片成功!");
    }

    @GetMapping("/preview")
    public Result postPic(@RequestParam int postId){

        PostPic postPics = postPicService.getPostPic(postId);

        if (postPics == null){
            return new Result(StatusCode.NOT_CONTENT, null, "该帖子无图片");
        }

        String base64 = fileUtils.toBase64(postPics.getPath());
        Map<String, String> map = new HashMap<>();
        map.put("base64", base64);

        return new Result(StatusCode.OK, map, "获取帖子图片成功!");
    }

}
