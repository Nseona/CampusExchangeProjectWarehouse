package com.example.campusexchange.controller;

import com.example.campusexchange.utils.Result;
import com.example.campusexchange.pojo.VisitorUser;
import com.example.campusexchange.service.VisitorUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private VisitorUserService visitorUserService;

    @PostMapping("/logon")
    private Result logOn(@RequestBody VisitorUser visitorUser){
        String userName = visitorUser.getUserName();
        logger.info("用户 userName = " + userName + ", 尝试登录");
        return visitorUserService.verifyVisitorUser(visitorUser);
    }

    @PostMapping("/signup")
    private Result signUp(@RequestBody VisitorUser visitorUser){
        String userName = visitorUser.getUserName();
        logger.info("用户 userName = " + userName + ", 尝试注册");
        return visitorUserService.registeredVisitorUser(visitorUser);
    }
}
