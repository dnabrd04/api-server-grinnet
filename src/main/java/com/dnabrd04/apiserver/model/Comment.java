package com.dnabrd04.apiserver.model;

import jakarta.persistence.*;

import java.util.Date;

/**
 * This class will be used to pass data from the "Comment" table to objects.
 * This class will store the id, the user, the post, the text, the
 * related comment and the creation date.
 *
 * @author dnabrd04
 */
@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_comment;

    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false, foreignKey = @ForeignKey(name = "FK_COMMENT_USER"))
    private User user;

    @ManyToOne
    @JoinColumn(name = "id_post", nullable = false, foreignKey = @ForeignKey(name = "FK_COMMENT_POST"))
    private Post post;

    @Column
    private String text;

    @ManyToOne
    @JoinColumn(name = "comment_related", foreignKey = @ForeignKey(name = "FK_COMMENT_COMMENT"))
    private Comment comment;

    @Column
    private Date creation_date;

    public Comment() {
    }

    public Comment(Long id_comment, User user, Post post, String text, Comment comment, Date creation_date) {
        this.id_comment = id_comment;
        this.user = user;
        this.post = post;
        this.text = text;
        this.comment = comment;
        this.creation_date = creation_date;
    }

    public Comment(User user, Post post, String text, Comment comment, Date creation_date) {
        this.user = user;
        this.post = post;
        this.text = text;
        this.comment = comment;
        this.creation_date = creation_date;
    }

    public Long getId_comment() {
        return id_comment;
    }

    public void setId_comment(Long id_comment) {
        this.id_comment = id_comment;
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public Date getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(Date creation_date) {
        this.creation_date = creation_date;
    }
}
