package com.example.campusexchange.testDao;

import com.example.campusexchange.dao.VisitorUserCollectDao;
import com.example.campusexchange.pojo.VisitorUserCollect;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
public class VisitorUserCollectDaoTest {

    @Autowired
    private VisitorUserCollectDao visitorUserCollectDao;

    @Test
    public void testInsertVisitorUserCollectOne(){
        VisitorUserCollect visitorUserCollect = new VisitorUserCollect();

        visitorUserCollect.setCollectTime(new Date());
        visitorUserCollect.setPostId(1);
        visitorUserCollect.setUserId(1);

        int i = visitorUserCollectDao.insertVisitorUserCollectOne(visitorUserCollect);
    }

    @Test
    public void testSelectCollectAllByPostId(){
        List<VisitorUserCollect> visitorUserCollects = visitorUserCollectDao.selectCollectAllByUserId(2);
        System.out.println(visitorUserCollects);
    }

    @Test
    public void testSelectCollectByUserIdAndPostId(){
        VisitorUserCollect visitorUserCollect = visitorUserCollectDao.selectCollectByUserIdAndPostId(2, 1);
        System.out.println(visitorUserCollect);
    }

    @Test
    public void testDeleteCollectByCollectId(){
        int i = visitorUserCollectDao.deleteCollectByCollectId(2);
        System.out.println(i);
    }
}
