package com.example.campusexchange.testService;

import com.example.campusexchange.config.Result;
import com.example.campusexchange.pojo.VisitorUser;
import com.example.campusexchange.service.VisitorUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
}
