package com.dnabrd04.apiserver.model;

import jakarta.persistence.*;

/**
 * This class will be used to pass data from the "Like" table to objects.
 * This class will store the id, the user and the post.
 *
 * @author dnabrd04
 */
@Entity
public class Like {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_like;

    @ManyToOne
    @JoinColumn(name = "id_user", foreignKey = @ForeignKey(name = "FK_LIKE_USER"), nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "id_post", foreignKey = @ForeignKey(name = "FK_LIKE_POST"), nullable = false)
    private Post post;

    public Like() {
    }

    public Like(Long id_like, User user, Post post) {
        this.id_like = id_like;
        this.user = user;
        this.post = post;
    }

    public Like(User user, Post post) {
        this.user = user;
        this.post = post;
    }

    public Long getId_like() {
        return id_like;
    }

    public void setId_like(Long id_like) {
        this.id_like = id_like;
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
