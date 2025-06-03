package com.dnabrd04.apiserver.dto;

public class PostDTORequest {
    private Long idPost;
    private String firebaseUserId;

    public PostDTORequest() {}

    public Long getIdPost() {
        return idPost;
    }

    public void setIdPost(Long idPost) {
        this.idPost = idPost;
    }

    public String getFirebaseUserId() {
        return firebaseUserId;
    }

    public void setFirebaseUserId(String firebaseUserId) {
        this.firebaseUserId = firebaseUserId;
    }
}
