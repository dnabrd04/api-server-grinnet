package com.dnabrd04.apiserver.dto;

import com.dnabrd04.apiserver.model.Post;
import com.dnabrd04.apiserver.model.Resource;
import com.dnabrd04.apiserver.model.User;

import java.util.Date;
import java.util.List;

public class PostDTO {

    private Long idPost;

    private PostDTO postRelated;

    private String text;

    private String privacity;

    private Date creationDate;

    private Long likeCount;

    private boolean isLiked;

    private Long commentCount;

    private User user;

    private List<Resource> resources;

    public PostDTO(Post post, Post postRelated, boolean isLiked) {
        this.idPost = post.getIdPost();
        this.text = post.getText();
        this.privacity = post.getPrivacity();
        this.creationDate = post.getCreation_date();
        this.user = post.getUser();
        this.likeCount = (long) post.getLikes().size();
        this.commentCount = (long) post.getComments().size();
        this.isLiked = isLiked;
        this.resources = post.getResources();

        if (postRelated != null) {
            this.postRelated = new PostDTO(postRelated.getIdPost(), postRelated.getText());
        }
    }

    public PostDTO(Long idPost, String text) {
        this.idPost = idPost;
        this.text = text;
    }

    public PostDTO(Long idPost, PostDTO postRelated, String text, String privacity, Date creationDate, User user, Long likeCount, Long commentCount, boolean isLiked, List<Resource> resources) {
        this.idPost = idPost;
        this.postRelated = postRelated;
        this.text = text;
        this.privacity = privacity;
        this.creationDate = creationDate;
        this.user = user;
        this.likeCount = likeCount;
        this.commentCount = commentCount;
        this.isLiked = isLiked;
        this.resources = resources;
    }

    public PostDTO(PostDTO postRelated, String text, String privacity, Date creationDate, User user, Long likeCount, Long commentCount, boolean isLiked, List<Resource> resources) {
        this.postRelated = postRelated;
        this.text = text;
        this.privacity = privacity;
        this.creationDate = creationDate;
        this.user = user;
        this.likeCount = likeCount;
        this.commentCount = commentCount;
        this.isLiked = isLiked;
        this.resources = resources;
    }

    public Long getIdPost() {
        return idPost;
    }

    public void setIdPost(Long id_post) {
        this.idPost = id_post;
    }

    public PostDTO getPostRelated() {
        return postRelated;
    }

    public void setPostRelated(PostDTO postRelated) {
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

    public boolean isLiked() {
        return isLiked;
    }

    public void setLiked(boolean liked) {
        isLiked = liked;
    }

    public List<Resource> getResources() {
        return resources;
    }

    public void setResources(List<Resource> resources) {
        this.resources = resources;
    }
}
