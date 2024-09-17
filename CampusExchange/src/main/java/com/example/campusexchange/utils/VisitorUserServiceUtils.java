package com.example.campusexchange.utils;

import com.example.campusexchange.dao.VisitorUserDao;
import com.example.campusexchange.exception.ServiceException;
import com.example.campusexchange.pojo.VisitorUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VisitorUserServiceUtils {
    @Autowired
    private VisitorUserDao visitorUserDao;

    public void verifyVisitorUserExistByVisitorUserId(int userId){
        VisitorUser visitorUser = visitorUserDao.selectVisitorUserOneById(userId);
        if (visitorUser == null){
            throw new ServiceException(StatusCode.NON_STANDARD, String.format("操作的用户 userId = %d 不存在!", userId));
        }
    }
}
