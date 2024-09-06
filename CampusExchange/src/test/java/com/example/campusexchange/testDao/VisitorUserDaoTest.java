package com.example.campusexchange.testDao;

import com.example.campusexchange.dao.VisitorUserDao;
import com.example.campusexchange.pojo.VisitorUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class VisitorUserDaoTest {
    @Autowired
    private VisitorUserDao visitorUserDao;

    @Test
    public void testsSelectVisitorUserOneByName(){
        VisitorUser aurora = visitorUserDao.selectVisitorUserOneByName("seve");
        System.out.println(aurora);
    }

    @Test
    public void testInsertVisitorUserOne(){
        VisitorUser visitorUser = new VisitorUser();
        visitorUser.setUserName("zghzgh");
        visitorUser.setUserPassword("333");

        int number = visitorUserDao.insertVisitorUserOne(visitorUser);
        System.out.println(number);
    }
}
