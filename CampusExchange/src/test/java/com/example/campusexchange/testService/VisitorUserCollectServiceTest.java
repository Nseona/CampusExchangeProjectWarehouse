package com.example.campusexchange.testService;

import com.example.campusexchange.service.VisitorUserCollectService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class VisitorUserCollectServiceTest {
    @Autowired
    private VisitorUserCollectService visitorUserCollectService;

    @Test
    public void testUserWhetherOrNotSelect(){
        boolean b = visitorUserCollectService.userWhetherOrNotSelect(1, 147);
        System.out.println(b);
    }
}
