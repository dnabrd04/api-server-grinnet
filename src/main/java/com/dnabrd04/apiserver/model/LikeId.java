package com.dnabrd04.apiserver.model;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class LikeId implements Serializable {
    private Long userPk;
    private Long postPk;

    public LikeId() {
    }

    public LikeId(Long user, Long post) {
        this.userPk = user;
        this.postPk = post;
    }

    public Long getUser() {
        return userPk;
    }

    public void setUser(Long user) {
        this.userPk = user;
    }

    public Long getPost() {
        return postPk;
    }

    public void setPost(Long post) {
        this.postPk = post;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LikeId likeId = (LikeId) o;
        return Objects.equals(userPk, likeId.userPk) && Objects.equals(postPk, likeId.postPk);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userPk, postPk);
    }
}
