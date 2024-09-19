package com.example.campusexchange.service;

import com.example.campusexchange.utils.Result;
import com.example.campusexchange.pojo.VisitorUser;

import java.util.List;
import java.util.Map;

public interface VisitorUserService {
    Result verifyVisitorUser(VisitorUser visitorUser);
    Result registeredVisitorUser(VisitorUser visitorUser);
    Map<String, Object> getUserCollectList(int userId, int pageNow, int pageSize);
    Map<String, Object> getUserLikeList(int userId, int pageNow, int pageSize);

    Map<String, Object> getVisitorUserInfo(int userId);

}
