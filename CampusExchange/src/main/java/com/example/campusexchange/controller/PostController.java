package com.example.campusexchange.controller;

import com.example.campusexchange.dto.Dto;
import com.example.campusexchange.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping("/posts")
    public Dto posts(@RequestParam(name = "pageNow", required = true) int pageNow,
                     @RequestParam(name = "pageSize", required = true) int pageSize){

        return postService.getPosts(pageNow, pageSize);
    }
}
