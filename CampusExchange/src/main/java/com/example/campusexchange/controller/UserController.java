package com.example.campusexchange.controller;

import com.example.campusexchange.utils.Result;
import com.example.campusexchange.pojo.VisitorUser;
import com.example.campusexchange.service.VisitorUserService;
import com.example.campusexchange.utils.StatusCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @GetMapping("/userCollect")
    private Result userCollect(@RequestParam int userId,
                               @RequestParam int pageNow,
                               @RequestParam int pageSize){
        Map<String, Object> data = visitorUserService.getUserCollectList(userId, pageNow, pageSize);

        Result result = new Result();
        result.setStatusCode(StatusCode.OK);
        result.setMessage(String.format("获取用户 id = %d 的收藏列表成功!", userId));
        result.setData(data);

        return result;
    }

    @GetMapping("/userLike")
    private Result userLike(@RequestParam int userId,
                            @RequestParam int pageNow,
                            @RequestParam int pageSize){
        Map<String, Object> data = visitorUserService.getUserLikeList(userId, pageNow, pageSize);

        Result result = new Result();
        result.setStatusCode(StatusCode.OK);
        result.setMessage(String.format("获取用户 id = %d 的点赞列表成功!", userId));
        result.setData(data);

        return result;
    }

    @GetMapping("/userInfo")
    private Result userInfo(@RequestParam int userId){
        Map<String, Object> visitorUserInfo = visitorUserService.getVisitorUserInfo(userId);

        HashMap<String, Object> data = new HashMap<>();
        data.put("userInfo", visitorUserInfo);

        Result result = new Result();
        result.setData(data);
        result.setMessage(String.format("获取用户 id = %d 个人信息成功", userId));
        result.setStatusCode(StatusCode.OK);

        return result;
    }




}
