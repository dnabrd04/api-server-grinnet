package com.dnabrd04.apiserver.model;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;

/**
 * This class will be used to pass data from the "Post" table to objects.
 * This class will store the id, the user, the related publication,
 * the privacy, the text and the creation date.
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
    @JoinColumn(name = "id_post", foreignKey = @ForeignKey(name = "FK_POST_POST"))
    private Post post;

    @Column
    private String privacity;

    @Column
    private String text;

    @Column
    private Date creation_date;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Comment> comments;

    /**
     * Empty constructor required for hibernate
     */
    public Post() {
    }

    public Post(Long id_post, User user, Post post, String privacity, String text, Date creation_date) {
        this.id_post = id_post;
        this.user = user;
        this.post = post;
        this.privacity = privacity;
        this.text = text;
        this.creation_date = creation_date;
    }

    public Post(User user, Post post, String privacity, String text, Date creation_date) {
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

    public Date getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(Date creation_date) {
        this.creation_date = creation_date;
    }
}
