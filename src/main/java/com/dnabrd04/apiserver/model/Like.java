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

    @EmbeddedId
    private LikeId id = new LikeId();

    @MapsId("userPk")
    @ManyToOne
    @JoinColumn(name = "id_user", foreignKey = @ForeignKey(name = "FK_LIKE_USER"), nullable = false)
    private User user;

    @MapsId("postPk")
    @ManyToOne
    @JoinColumn(name = "id_post", foreignKey = @ForeignKey(name = "FK_LIKE_POST"), nullable = false)
    private Post post;

    public Like() {
    }

    public Like(LikeId id, User user, Post post) {
        this.id = id;
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

    public LikeId getId() {
        return id;
    }

    public void setId(LikeId id) {
        this.id = id;
    }
}