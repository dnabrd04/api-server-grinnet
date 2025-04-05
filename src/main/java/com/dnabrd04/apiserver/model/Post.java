package com.dnabrd04.apiserver.model;

import jakarta.persistence.*;

/**
 * This class will be used to pass data from the "Post" table to objects.
 *
 * @author dnabrd04
 */
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_post;

    // User that publicate this post
    @ManyToOne
    @JoinColumn(name = "id_user", foreignKey = @ForeignKey(name = "FK_POST_USER"), nullable = false)
    private User user;

    // Post that be related with this post if it has
    @ManyToOne
    @JoinColumn(name = "id_user", foreignKey = @ForeignKey(name = "FK_POST_USER"))
    private Post post;

    @Column
    private String privacity;

    @Column
    private String text;

    @Column
    private String creation_date;

    /**
     * Empty constructor required for hibernate
     */
    public Post() {
    }

    public Post(Long id_post, User user, Post post, String privacity, String text, String creation_date) {
        this.id_post = id_post;
        this.user = user;
        this.post = post;
        this.privacity = privacity;
        this.text = text;
        this.creation_date = creation_date;
    }

    public Post(User user, Post post, String privacity, String text, String creation_date) {
        this.user = user;
        this.post = post;
        this.privacity = privacity;
        this.text = text;
        this.creation_date = creation_date;
    }

    public Long getId_post() {
        return id_post;
    }

    public void setId_post(Long id_post) {
        this.id_post = id_post;
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

    public String getPrivacity() {
        return privacity;
    }

    public void setPrivacity(String privacity) {
        this.privacity = privacity;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(String creation_date) {
        this.creation_date = creation_date;
    }
}
