package com.example.campusexchange.pojo;

import java.util.Date;

public class PostPic {
    private Integer postPicId;
    private Integer postId;
    private String path;
    private Date uploadTime;

    public PostPic(Integer postPicId, Integer postId, String path, Date uploadTime) {
        this.postPicId = postPicId;
        this.postId = postId;
        this.path = path;
        this.uploadTime = uploadTime;
    }

    public PostPic() {
    }

    @Override
    public String toString() {
        return "PostPic{" +
                "postPicId=" + postPicId +
                ", postId=" + postId +
                ", path='" + path + '\'' +
                ", uploadTime=" + uploadTime +
                '}';
    }

    public Integer getPostPicId() {
        return postPicId;
    }

    public void setPostPicId(Integer postPicId) {
        this.postPicId = postPicId;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Date getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }
}
