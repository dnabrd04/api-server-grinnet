package com.dnabrd04.apiserver.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * This class will be used to pass data from the "Like" table to objects.
 * This class will store the id, the user and the post.
 *
 * @author dnabrd04
 */
@Entity
@Table(name = "likes")//This is necessary because “like” is a reserved word.
public class Like {

    @Id
    @ManyToOne
    @JoinColumn(name = "id_user", foreignKey = @ForeignKey(name = "FK_LIKE_USER"), nullable = false)
    private User user;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_post", foreignKey = @ForeignKey(name = "FK_LIKE_POST"), nullable = false)
    private Post post;

    public Like() {
    }

    public Like(Long id_like, User user, Post post) {
        this.user = user;
        this.post = post;
    }

    public Like(User user, Post post) {
        this.user = user;
        this.post = post;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}

class LikeId implements Serializable {
    private Long user;
    private Long post;

    public LikeId() {
    }

    public LikeId(Long user, Long post) {
        this.user = user;
        this.post = post;
    }

    public Long getUser() {
        return user;
    }

    public void setUser(Long user) {
        this.user = user;
    }

    public Long getPost() {
        return post;
    }

    public void setPost(Long post) {
        this.post = post;
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
        return Objects.equals(user, likeId.user) && Objects.equals(post, likeId.post);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, post);
    }
}
