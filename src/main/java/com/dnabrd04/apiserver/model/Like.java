package com.dnabrd04.apiserver.model;

import jakarta.persistence.*;

/**
 * This class will be used to pass data from the "Post" table to objects.
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
}
