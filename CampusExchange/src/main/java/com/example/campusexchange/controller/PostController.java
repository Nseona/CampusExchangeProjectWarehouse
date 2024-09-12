package com.example.campusexchange.controller;

import com.example.campusexchange.pojo.Post;
import com.example.campusexchange.utils.Result;
import com.example.campusexchange.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping("/posts")
    public Result posts(@RequestParam(name = "pageNow", required = true) int pageNow,
                        @RequestParam(name = "pageSize", required = true) int pageSize){

        return postService.getPosts(pageNow, pageSize);
    }

    @PostMapping("/upload")
    public void post(@RequestBody MultipartFile file){
        String originalFilename = file.getOriginalFilename();
        try {
            file.transferTo(new File("C:/Users/Lucky/Pictures/1.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
