package com.example.campusexchange.pojo;

import java.util.Date;
import java.util.Objects;

public class VisitorUserCollect {
    private Integer visitorUserCollectId;
    private Integer userId;
    private Integer postId;
    private Date collectTime;

    public VisitorUserCollect() {
    }

    public VisitorUserCollect(Integer userId, Integer postId, Date collectTime) {
        this.userId = userId;
        this.postId = postId;
        this.collectTime = collectTime;
    }

    @Override
    public String toString() {
        return "VisitorUserCollect{" +
                "visitorUserCollectId=" + visitorUserCollectId +
                ", userId=" + userId +
                ", postId=" + postId +
                ", collectTime=" + collectTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VisitorUserCollect that = (VisitorUserCollect) o;
        return Objects.equals(visitorUserCollectId, that.visitorUserCollectId) && Objects.equals(userId, that.userId) && Objects.equals(postId, that.postId) && Objects.equals(collectTime, that.collectTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(visitorUserCollectId, userId, postId, collectTime);
    }

    public Integer getVisitorUserCollectId() {
        return visitorUserCollectId;
    }

    public void setVisitorUserCollectId(Integer visitorUserCollectId) {
        this.visitorUserCollectId = visitorUserCollectId;
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

    public Date getCollectTime() {
        return collectTime;
    }

    public void setCollectTime(Date collectTime) {
        this.collectTime = collectTime;
    }
}
