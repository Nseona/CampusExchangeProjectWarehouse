package com.example.campusexchange.service.impl;

import com.example.campusexchange.dao.VisitorUserCollectDao;
import com.example.campusexchange.pojo.VisitorUserCollect;
import com.example.campusexchange.service.VisitorUserCollectService;
import com.example.campusexchange.utils.PostServiceUtils;
import com.example.campusexchange.utils.VisitorUserServiceUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VisitorUserCollectServiceImpl implements VisitorUserCollectService {
    @Autowired
    private VisitorUserCollectDao visitorUserCollectDao;

    @Autowired
    private VisitorUserServiceUtils visitorUserServiceUtils;

    @Autowired
    private PostServiceUtils postServiceUtils;
    @Override
    public boolean userWhetherOrNotSelect(int userId, int postId) {

        visitorUserServiceUtils.verifyVisitorUserExistByVisitorUserId(userId);
        postServiceUtils.verifyPostExistByPostId(postId);

        VisitorUserCollect visitorUserCollect = visitorUserCollectDao.selectCollectByUserIdAndPostId(userId, postId);
        return visitorUserCollect != null;
    }
}
