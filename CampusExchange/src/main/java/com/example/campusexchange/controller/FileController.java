package com.example.campusexchange.controller;

import com.example.campusexchange.utils.FileUtils;
import com.example.campusexchange.utils.Result;
import com.example.campusexchange.utils.StatusCode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/file")
public class FileController {
    @Value("fileRootPath")
    private String fileRootPath;

    @GetMapping
    public Result img(@RequestParam String path){
        String base64 = FileUtils.toBase64(fileRootPath + path);
        HashMap<String, String> data = new HashMap<>();
        data.put("base64", base64);
        return new Result(StatusCode.OK, data, "传输成功");
    }

}
