package com.example.campusexchange.controller;

import com.example.campusexchange.utils.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/postPic")
public class PostPicController {


    @GetMapping
    public Result postPic(@RequestParam int postId){


        return null;
    }
}
