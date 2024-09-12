package com.example.campusexchange.controller;

import com.example.campusexchange.utils.Result;
import com.example.campusexchange.pojo.VisitorUser;
import com.example.campusexchange.service.VisitorUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private VisitorUserService visitorUserService;

    @PostMapping("/logon")
    private Result logOn(@RequestBody VisitorUser visitorUser){
        return visitorUserService.verifyVisitorUser(visitorUser);
    }

    @PostMapping("/signup")
    private Result signUp(@RequestBody VisitorUser visitorUser){
        return visitorUserService.registeredVisitorUser(visitorUser);
    }
}
