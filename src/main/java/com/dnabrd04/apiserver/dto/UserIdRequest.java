package com.dnabrd04.apiserver.dto;

public class UserIdRequest {
    private String firebaseUserId;

    public UserIdRequest() {
    }

    public UserIdRequest(String firebaseUserId) {
        this.firebaseUserId = firebaseUserId;
    }

    public String getFirebaseUserId() {
        return firebaseUserId;
    }

    public void setFirebaseUserId(String firebaseUserId) {
        this.firebaseUserId = firebaseUserId;
    }
}
