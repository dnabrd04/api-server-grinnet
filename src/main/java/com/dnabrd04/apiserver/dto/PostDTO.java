package com.dnabrd04.apiserver.dto;

import com.dnabrd04.apiserver.model.User;

import java.util.Date;

public class PostDTO {

    private Long idPost;

    private String text;

    private String privacity;

    private Date creationDate;

    private int likeCount;

    private int commentCount;

    private User user;

    public PostDTO(Long idPost, String text, String privacity, Date creationDate, User user, int likeCount, int commentCount) {
        this.idPost = idPost;
        this.text = text;
        this.privacity = privacity;
        this.creationDate = creationDate;
        this.user = user;
        this.likeCount = likeCount;
        this.commentCount = commentCount;
    }

    public Long getIdPost() {
        return idPost;
    }

    public void setIdPost(Long idPost) {
        this.idPost = idPost;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getPrivacity() {
        return privacity;
    }

    public void setPrivacity(String privacity) {
        this.privacity = privacity;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
