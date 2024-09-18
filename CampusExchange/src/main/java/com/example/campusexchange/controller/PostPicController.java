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

    @GetMapping
    public Result postPicBase64List(@RequestParam int postId){

        List<String> postPicBase64List = postPicService.getPostPicBase64List(postId);

        Map<String, List<String>> map = new HashMap<>();
        map.put("base64List", postPicBase64List);

        return new Result(StatusCode.OK, map, "获取帖子图片成功!");
    }

    @GetMapping("/preview")
    public Result postPicBase64(@RequestParam int postId){

        String postPicBase64 = postPicService.getPostPicBase64(postId);

        Map<String, String> map = new HashMap<>();
        map.put("base64", postPicBase64);

        return new Result(StatusCode.OK, map, "获取帖子图片成功!");
    }

}
