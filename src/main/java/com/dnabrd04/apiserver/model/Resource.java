package com.dnabrd04.apiserver.model;

import jakarta.persistence.*;

/**
 * This class will be used to pass data from the "Image" table to objects.
 * This class will store the id, the url, the post and the order.
 * @author dnabrd04
 */
@Entity
public class Resource {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_resource;

    // Url of the resource storage on firebase.
    @Column
    private String url;

    // Post the resource belongs to.
    @ManyToOne
    @JoinColumn(nullable = false, name = "id_post", foreignKey = @ForeignKey(name = "FK_IMAGE_POST"))
    private Post post;

    // The order in which the resources will be displayed. Useful when there are several resources
    @Column(name = "resource_order")//This is necessary because “order” is a reserved word.
    private int order;

    public Resource() {
    }

    public Resource(Long id_resource, String url, Post post, int order) {
        this.id_resource = id_resource;
        this.url = url;
        this.post = post;
        this.order = order;
    }

    public Resource(String url, Post post, int order) {
        this.url = url;
        this.post = post;
        this.order = order;
    }

    public Long getId_resource() {
        return id_resource;
    }

    public void setId_resource(Long id_resource) {
        this.id_resource = id_resource;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }
}
