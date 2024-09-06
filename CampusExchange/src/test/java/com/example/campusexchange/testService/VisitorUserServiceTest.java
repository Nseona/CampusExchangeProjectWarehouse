package com.example.campusexchange.testService;

import com.example.campusexchange.dto.Dto;
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

        Dto dto = visitorUserService.verifyVisitorUser(visitorUser);

        System.out.println(dto);
    }

    @Test
    public void testRegisteredVisitorUser(){
        VisitorUser visitorUser = new VisitorUser();
        Dto dto = new Dto();

        visitorUser.setUserName("avf@");
        dto = visitorUserService.registeredVisitorUser(visitorUser);
        System.out.println(dto.getMessage());

        visitorUser.setUserName("asdf");
        visitorUser.setUserPassword("1234");
        dto = visitorUserService.registeredVisitorUser(visitorUser);
        System.out.println(dto.getMessage());

        visitorUser.setUserName("lucky");
        visitorUser.setUserPassword("aaaaaaaa");
        dto = visitorUserService.registeredVisitorUser(visitorUser);
        System.out.println(dto.getMessage());

        visitorUser.setUserName("zzgghh");
        visitorUser.setUserPassword("aaaaaaaa");
        dto = visitorUserService.registeredVisitorUser(visitorUser);
        System.out.println(dto.getMessage());

    }
}
