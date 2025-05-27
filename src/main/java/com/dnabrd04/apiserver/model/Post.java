package com.dnabrd04.apiserver.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Date;
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
    private Long idPost;

    // User that publicate this post.
    @ManyToOne
    @JoinColumn(name = "id_user", foreignKey = @ForeignKey(name = "FK_POST_USER"), nullable = false)
    private User user;

    // Post that be related with this post if it has.
    @ManyToOne
    @JoinColumn(name = "post_related", foreignKey = @ForeignKey(name = "FK_POST_POST"))
    private Post post;

    // The privacity of the post.
    @Column
    private String privacity;

    // The content of the publication.
    @Column
    private String text;

    // Creation date of the post.
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss", shape = JsonFormat.Shape.STRING)
    @Column
    private Date creation_date;

    // Comments related with this post.
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Comment> comments;

    // Likes related with this post.
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Like> likes;

    // Likes related with this post.
    @JsonManagedReference
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Resource> resources;

    /**
     * Empty constructor required for hibernate
     */
    public Post() {
    }

    public Post(Long idPost, User user, Post post, String privacity, String text, Date creation_date, List<Resource> resources) {
        this.idPost = idPost;
        this.user = user;
        this.post = post;
        this.privacity = privacity;
        this.text = text;
        this.creation_date = creation_date;
        this.resources = resources;
    }

    public Post(User user, Post post, String privacity, String text, Date creation_date, List<Resource> resources) {
        this.user = user;
        this.post = post;
        this.privacity = privacity;
        this.text = text;
        this.creation_date = creation_date;
        this.resources = resources;
    }

    public Long getIdPost() {
        return idPost;
    }

    public void setIdPost(Long idPost) {
        this.idPost = idPost;
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

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Like> getLikes() {
        return likes;
    }

    public void setLikes(List<Like> likes) {
        this.likes = likes;
    }

    public List<Resource> getResources() {
        return resources;
    }

    public void setResources(List<Resource> resources) {
        this.resources = resources;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id_post=" + idPost +
                ", user=" + user +
                ", post=" + post +
                ", privacity='" + privacity + '\'' +
                ", text='" + text + '\'' +
                ", creation_date=" + creation_date +
                ", comments=" + comments +
                ", likes=" + likes +
                '}';
    }
}
