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
@Table(name = "users")//This is necessary because “user” is a reserved word.
public class User {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    private Long id_user;

    // Image of the user
    @Column
    private String image;

    // Username of the user
    @Column
    private String username;

    // Privacity of the user
    @Column
    private String privacity;

    // The firebase id related with this user
    @Column(name = "firebase_id")
    private String firebaseId;

    // The name of the user
    @Column
    private String name;

    // A short description of the user.
    @Column
    private String description;

    // The comments related that have been maked by this user
    @OneToMany(mappedBy = "user")
    private List<Comment> comments;

    // The posts related that have been maked by this user
    @OneToMany(mappedBy = "user")
    private List<Post> posts;

    // The likes related that have been maked by this user
    @OneToMany(mappedBy = "user")
    private List<Like> likes;

    /**
     * Empty constructor required for hibernate
     */
    public User() {
    }

    public User(Long id_user, String image, String username, String privacity, String firebaseId, String name, String description) {
        this.id_user = id_user;
        this.image = image;
        this.username = username;
        this.privacity = privacity;
        this.firebaseId = firebaseId;
        this.name = name;
        this.description = description;
    }

    public User(String image, String username, String privacity, String firebaseId, String name, String description) {
        this.image = image;
        this.username = username;
        this.privacity = privacity;
        this.firebaseId = firebaseId;
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

    public String getFirebaseId() {
        return firebaseId;
    }

    public void setFirebaseId(String firebaseId) {
        this.firebaseId = firebaseId;
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
