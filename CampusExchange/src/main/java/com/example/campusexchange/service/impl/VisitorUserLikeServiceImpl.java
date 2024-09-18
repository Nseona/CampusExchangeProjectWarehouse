package com.example.campusexchange.service.impl;

import com.example.campusexchange.dao.VisitorUserLikeDao;
import com.example.campusexchange.pojo.VisitorUserLike;
import com.example.campusexchange.service.VisitorUserLikeService;
import com.example.campusexchange.utils.PostServiceUtils;
import com.example.campusexchange.utils.VisitorUserServiceUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VisitorUserLikeServiceImpl implements VisitorUserLikeService {
    @Autowired
    private VisitorUserLikeDao visitorUserLikeDao;

    @Autowired
    private VisitorUserServiceUtils visitorUserServiceUtils;

    @Autowired
    private PostServiceUtils postServiceUtils;
    @Override
    public boolean userWhetherOrNotSelect(int userId, int postId) {

        visitorUserServiceUtils.verifyVisitorUserExistByVisitorUserId(userId);
        postServiceUtils.verifyPostExistByPostId(postId);

        VisitorUserLike visitorUserLike = visitorUserLikeDao.selectLikeByUserIdAndPostId(userId, postId);
        return visitorUserLike != null;
    }
}
