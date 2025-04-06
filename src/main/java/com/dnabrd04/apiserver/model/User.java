package com.dnabrd04.apiserver.model;

import jakarta.persistence.*;

import java.util.List;

/**
 * This class will be used to pass data from the "User" table to objects.
 * This class will store the id, the image, the username, the privacy,
 * the firebase id, the name and the description.
 *
 * @author dnabrd04
 */
@Entity
public class User {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    private Long id_user;

    @Column
    private String image;

    @Column
    private String username;

    @Column
    private String privacity;

    @Column
    private String firebase_id;

    @Column
    private String name;

    @Column
    private String description;

    @OneToMany(mappedBy = "user")
    private List<Comment> comments;

    @OneToMany(mappedBy = "user")
    private List<Like> likes;

    /**
     * Empty constructor required for hibernate
     */
    public User() {
    }

    public User(Long id_user, String image, String username, String privacity, String firebase_id, String name, String description) {
        this.id_user = id_user;
        this.image = image;
        this.username = username;
        this.privacity = privacity;
        this.firebase_id = firebase_id;
        this.name = name;
        this.description = description;
    }

    public User(String image, String username, String privacity, String firebase_id, String name, String description) {
        this.image = image;
        this.username = username;
        this.privacity = privacity;
        this.firebase_id = firebase_id;
        this.name = name;
        this.description = description;
    }

    public Long getId_user() {
        return id_user;
    }

    public void setId_user(Long id_user) {
        this.id_user = id_user;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPrivacity() {
        return privacity;
    }

    public void setPrivacity(String privacity) {
        this.privacity = privacity;
    }

    public String getFirebase_id() {
        return firebase_id;
    }

    public void setFirebase_id(String firebase_id) {
        this.firebase_id = firebase_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
