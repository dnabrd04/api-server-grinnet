package com.dnabrd04.apiserver.dto;

import com.dnabrd04.apiserver.model.Post;
import com.dnabrd04.apiserver.model.User;

import java.util.Date;

public class PostDTO {

    private Long id_post;

    private Post postRelated;

    private String text;

    private String privacity;

    private Date creationDate;

    private Long likeCount;

    private Long commentCount;

    private User user;

    public PostDTO(Long id_post, Post postRelated, String text, String privacity, Date creationDate, User user, Long likeCount, Long commentCount) {
        this.id_post = id_post;
        this.postRelated = postRelated;
        this.text = text;
        this.privacity = privacity;
        this.creationDate = creationDate;
        this.user = user;
        this.likeCount = likeCount;
        this.commentCount = commentCount;
    }

    public PostDTO(Post postRelated, String text, String privacity, Date creationDate, User user, Long likeCount, Long commentCount) {
        this.postRelated = postRelated;
        this.text = text;
        this.privacity = privacity;
        this.creationDate = creationDate;
        this.user = user;
        this.likeCount = likeCount;
        this.commentCount = commentCount;
    }

    public Long getIdPost() {
        return id_post;
    }

    public void setIdPost(Long id_post) {
        this.id_post = id_post;
    }

    public Post getPostRelated() {
        return postRelated;
    }

    public void setPostRelated(Post postRelated) {
        this.postRelated = postRelated;
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

    public Long getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Long likeCount) {
        this.likeCount = likeCount;
    }

    public Long getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Long commentCount) {
        this.commentCount = commentCount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
