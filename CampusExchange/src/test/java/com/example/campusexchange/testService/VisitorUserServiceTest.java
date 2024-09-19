package com.example.campusexchange.testService;

import com.example.campusexchange.utils.Result;
import com.example.campusexchange.pojo.VisitorUser;
import com.example.campusexchange.service.VisitorUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest
public class VisitorUserServiceTest {
    @Autowired
    private VisitorUserService visitorUserService;

    @Test
    public void testVerifyVisitorUser(){
        VisitorUser visitorUser = new VisitorUser();

        visitorUser.setUserName("lucky");
        visitorUser.setUserPassword("123456");

        Result result = visitorUserService.verifyVisitorUser(visitorUser);

        System.out.println(result);
    }

    @Test
    public void testRegisteredVisitorUser(){
        VisitorUser visitorUser = new VisitorUser();
        Result result = new Result();

        visitorUser.setUserName("avf@");
        result = visitorUserService.registeredVisitorUser(visitorUser);
        System.out.println(result.getMessage());

        visitorUser.setUserName("asdf");
        visitorUser.setUserPassword("1234");
        result = visitorUserService.registeredVisitorUser(visitorUser);
        System.out.println(result.getMessage());

        visitorUser.setUserName("lucky");
        visitorUser.setUserPassword("aaaaaaaa");
        result = visitorUserService.registeredVisitorUser(visitorUser);
        System.out.println(result.getMessage());

        visitorUser.setUserName("zzgghh");
        visitorUser.setUserPassword("aaaaaaaa");
        result = visitorUserService.registeredVisitorUser(visitorUser);
        System.out.println(result.getMessage());

    }

    @Test
    public void testGetUserCollectList(){
        List<Map<String, Object>> userCollectList = visitorUserService.getUserCollectList(182);
        userCollectList.forEach(item -> {
            System.out.println(item);
        });
    }

    @Test
    public void testGetUserLikeList(){
        List<Map<String, Object>> userLikeList = visitorUserService.getUserLikeList(182);
        userLikeList.forEach(item -> {
            System.out.println(item);
        });
    }

    @Test
    public void testGetVisitorUserInfo(){
        Map<String, Object> visitorUserInfo = visitorUserService.getVisitorUserInfo(182);
        System.out.println(visitorUserInfo);
    }
}
