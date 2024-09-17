package com.example.campusexchange.testDao;

import com.example.campusexchange.dao.VisitorUserCollectDao;
import com.example.campusexchange.dao.VisitorUserLikeDao;
import com.example.campusexchange.pojo.VisitorUserCollect;
import com.example.campusexchange.pojo.VisitorUserLike;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
public class VisitorUserLikeDaoTest {

    @Autowired
    private VisitorUserLikeDao visitorUserLikeDao;

    @Test
    public void testInsertVisitorUserLikeOne(){
        VisitorUserLike visitorUserLike = new VisitorUserLike();

        visitorUserLike.setLikeTime(new Date());
        visitorUserLike.setPostId(1);
        visitorUserLike.setUserId(1);

        int i = visitorUserLikeDao.insertVisitorUserLikeOne(visitorUserLike);
    }

    @Test
    public void testSelectLikeAllByPostId(){
        List<VisitorUserLike> visitorUserLikes = visitorUserLikeDao.selectLikeAllByUserId(1);
        System.out.println(visitorUserLikes);
    }

    @Test
    public void testSelectLikeByUserIdAndPostId(){
        VisitorUserLike visitorUserLike = visitorUserLikeDao.selectLikeByUserIdAndPostId(1, 1);
        System.out.println(visitorUserLike);
    }

    @Test
    public void testDeleteLikeByLikeId(){
        int i = visitorUserLikeDao.deleteLikeByLikeId(1);

    }
}
