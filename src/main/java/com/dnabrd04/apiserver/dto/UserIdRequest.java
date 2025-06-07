package com.dnabrd04.apiserver.dto;

public class UserIdRequest {

    private Long userId;

    private String firebaseUserId;

    public UserIdRequest() {
    }

    public UserIdRequest(String firebaseUserId) {
        this.firebaseUserId = firebaseUserId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFirebaseUserId() {
        return firebaseUserId;
    }

    public void setFirebaseUserId(String firebaseUserId) {
        this.firebaseUserId = firebaseUserId;
    }
}
