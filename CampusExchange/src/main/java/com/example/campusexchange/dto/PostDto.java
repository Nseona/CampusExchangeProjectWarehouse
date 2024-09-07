package com.example.campusexchange.dto;

import java.util.Date;

public class PostDto {
    private Integer postId;
    private Date postPostingTime;
    private String postTextContent;
    private Integer postVisitorUserId;
    private String postTitle;
    private String userName;

    public PostDto(Integer postId, Date postPostingTime, String postTextContent, Integer postVisitorUserId, String postTitle, String userName) {
        this.postId = postId;
        this.postPostingTime = postPostingTime;
        this.postTextContent = postTextContent;
        this.postVisitorUserId = postVisitorUserId;
        this.postTitle = postTitle;
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "PostDto{" +
                "postId=" + postId +
                ", postPostingTime=" + postPostingTime +
                ", postTextContent='" + postTextContent + '\'' +
                ", postVisitorUserId=" + postVisitorUserId +
                ", postTitle='" + postTitle + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }

    public PostDto() {
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public Date getPostPostingTime() {
        return postPostingTime;
    }

    public void setPostPostingTime(Date postPostingTime) {
        this.postPostingTime = postPostingTime;
    }

    public String getPostTextContent() {
        return postTextContent;
    }

    public void setPostTextContent(String postTextContent) {
        this.postTextContent = postTextContent;
    }

    public Integer getPostVisitorUserId() {
        return postVisitorUserId;
    }

    public void setPostVisitorUserId(Integer postVisitorUserId) {
        this.postVisitorUserId = postVisitorUserId;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
