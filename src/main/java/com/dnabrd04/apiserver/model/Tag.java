package com.dnabrd04.apiserver.model;

import jakarta.persistence.*;

/**
 * This class will be used to pass data from the "Tag" table to objects.
 * This class will store the id, and the text.
 *
 * @author dnabrd04
 */
@Entity
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_tag;

    @Column
    private String text;

    public Tag() {
    }

    public Tag(Long id_tag, String text) {
        this.id_tag = id_tag;
        this.text = text;
    }

    public Tag(String text) {
        this.text = text;
    }

    public Long getId_tag() {
        return id_tag;
    }

    public void setId_tag(Long id_tag) {
        this.id_tag = id_tag;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
