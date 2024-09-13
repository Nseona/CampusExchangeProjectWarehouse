package com.example.campusexchange.controller;

import com.example.campusexchange.pojo.Post;
import com.example.campusexchange.utils.Result;
import com.example.campusexchange.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

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
    public void post(@RequestParam MultipartFile[] fileList, @RequestParam String abc){

        for (int i = 0; i < fileList.length; i++){
            File dest = new File("C:/Users/Lucky/Desktop/campus-exchange-project-warehouse/CampusExchange/src/main/resources/static/" + fileList[i].getOriginalFilename());
            try {
                fileList[i].transferTo(dest);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println(fileList[i]);
        }


//        Arrays.stream(fileList).forEach(item -> {
//            File dest = new File("C:/Users/Lucky/Pictures");
//            try {
//                item.transferTo(dest);
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//            System.out.println(item);
//        });

//        String originalFilename = file.getOriginalFilename();
//        try {
//            file.transferTo(new File("C:/Users/Lucky/Pictures/1.png"));
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
    }

}
