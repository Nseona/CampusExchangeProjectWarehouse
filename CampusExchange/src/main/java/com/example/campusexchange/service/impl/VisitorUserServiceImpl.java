package com.example.campusexchange.service.impl;

import com.example.campusexchange.dao.VisitorUserDao;
import com.example.campusexchange.config.Result;
import com.example.campusexchange.exception.ServiceException;
import com.example.campusexchange.pojo.VisitorUser;
import com.example.campusexchange.service.VisitorUserService;
import com.example.campusexchange.statusCode.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VisitorUserServiceImpl implements VisitorUserService {
    @Autowired
    private VisitorUserDao visitorUserDao;

    @Override
    public Result verifyVisitorUser(VisitorUser visitorUser) {
        String userName = visitorUser.getUserName();
        String userPassword = visitorUser.getUserPassword();
        VisitorUser user = visitorUserDao.selectVisitorUserOneByName(userName);

        if (user == null){
            throw new ServiceException(StatusCode.unauthorized, "用户不存在!");
        }

        if (!user.getUserPassword().equals(userPassword)){
            throw new ServiceException(StatusCode.unauthorized, "密码错误!");
        }

        return new Result(StatusCode.OK, "登录成功!");
    }

    @Override
    public Result registeredVisitorUser(VisitorUser visitorUser) {
        String userName = visitorUser.getUserName();
        String userPassword = visitorUser.getUserPassword();

        String userNameRegex = "^[A-Za-z0-9_]+$";
        String userPasswordRegex = "^[A-Za-z0-9_]{8,}$";

        if (!userName.matches(userNameRegex)){
            throw new ServiceException(StatusCode.nonStandard, "用户名格式错误, 仅包含字母数字下划线");
        }

        if (!userPassword.matches(userPasswordRegex)){
            throw new ServiceException(StatusCode.nonStandard, "密码格式错误, 至少8位且仅包含字母数字下划线");
        }

        VisitorUser user = visitorUserDao.selectVisitorUserOneByName(userName);

        if (user != null){
            throw new ServiceException(StatusCode.nonStandard, "用户名已经存在!");
        }

        int number = visitorUserDao.insertVisitorUserOne(visitorUser);

        if (number != 1){
            throw new ServiceException(StatusCode.unknownServerError, "服务器繁忙...");
        }

        return new Result(StatusCode.OK, "注册成功!跳转至登录页");
    }
}
