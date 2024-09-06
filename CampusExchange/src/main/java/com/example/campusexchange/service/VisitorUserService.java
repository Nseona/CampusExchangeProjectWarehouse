package com.example.campusexchange.service;

import com.example.campusexchange.dto.Dto;
import com.example.campusexchange.pojo.VisitorUser;

public interface VisitorUserService {
    Dto verifyVisitorUser(VisitorUser visitorUser);
    Dto registeredVisitorUser(VisitorUser visitorUser);
}
