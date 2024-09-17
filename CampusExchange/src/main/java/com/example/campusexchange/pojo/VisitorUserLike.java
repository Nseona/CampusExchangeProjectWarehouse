package com.example.campusexchange.pojo;

import java.util.Date;
import java.util.Objects;

public class VisitorUserLike {
    private Integer visitorUserLikeId;
    private Integer userId;
    private Integer postId;
    private Date likeTime;

    public VisitorUserLike() {
    }

    public VisitorUserLike(Integer userId, Integer postId, Date likeTime) {
        this.userId = userId;
        this.postId = postId;
        this.likeTime = likeTime;
    }

    @Override
    public String toString() {
        return "VisitorUserCollect{" +
                "visitorUserCollectId=" + visitorUserLikeId +
                ", userId=" + userId +
                ", postId=" + postId +
                ", collectTime=" + likeTime +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(visitorUserLikeId, userId, postId, likeTime);
    }

    public Integer getVisitorUserLikeId() {
        return visitorUserLikeId;
    }

    public void setVisitorUserLikeId(Integer visitorUserLikeId) {
        this.visitorUserLikeId = visitorUserLikeId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public Date getLikeTime() {
        return likeTime;
    }

    public void setLikeTime(Date likeTime) {
        this.likeTime = likeTime;
    }

}
