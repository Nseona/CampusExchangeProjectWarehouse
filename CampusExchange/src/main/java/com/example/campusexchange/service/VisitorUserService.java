package com.example.campusexchange.service;

import com.example.campusexchange.utils.Result;
import com.example.campusexchange.pojo.VisitorUser;

public interface VisitorUserService {
    Result verifyVisitorUser(VisitorUser visitorUser);
    Result registeredVisitorUser(VisitorUser visitorUser);
}
