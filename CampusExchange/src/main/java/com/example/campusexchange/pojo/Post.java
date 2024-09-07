package com.example.campusexchange.pojo;

import java.util.Date;
import java.util.Objects;

public class Post {
    private Integer postId;
    private Date postPostingTime;
    private String postTextContent;
    private Integer postVisitorUserId;
    private String postTitle;

    public Post() {
    }

    public Post(Integer postId, Date postPostingTime, String postTextContent, Integer postVisitorUserId, String postTitle) {
        this.postId = postId;
        this.postPostingTime = postPostingTime;
        this.postTextContent = postTextContent;
        this.postVisitorUserId = postVisitorUserId;
        this.postTitle = postTitle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(postId, post.postId) && Objects.equals(postPostingTime, post.postPostingTime) && Objects.equals(postTextContent, post.postTextContent) && Objects.equals(postVisitorUserId, post.postVisitorUserId) && Objects.equals(postTitle, post.postTitle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(postId, postPostingTime, postTextContent, postVisitorUserId, postTitle);
    }

    @Override
    public String toString() {
        return "Post{" +
                "postId=" + postId +
                ", postPostingTime=" + postPostingTime +
                ", postTextContent='" + postTextContent + '\'' +
                ", postVisitorUserId=" + postVisitorUserId +
                ", postTitle='" + postTitle + '\'' +
                '}';
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
}
