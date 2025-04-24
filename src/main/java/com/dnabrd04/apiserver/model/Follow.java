package com.dnabrd04.apiserver.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Follow {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idFollow;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "FK_FOLLOW_USER_FOLLOWER"), nullable = false)
    private User follower;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "FK_FOLLOW_USER_FOLLOWED"), nullable = false)
    private User followed;

    @Column
    private Date follow_date;

    /**
     * Empty constructor required for hibernate
     */
    public Follow() {

    }

    public Follow(Long idFollow, User follower, User followed, Date follow_date) {
        this.idFollow = idFollow;
        this.follower = follower;
        this.followed = followed;
        this.follow_date = follow_date;
    }

    public Follow(User follower, User followed, Date follow_date) {
        this.follower = follower;
        this.followed = followed;
        this.follow_date = follow_date;
    }

    public Long getIdFollow() {
        return idFollow;
    }

    public void setIdFollow(Long idFollow) {
        this.idFollow = idFollow;
    }

    public User getFollower() {
        return follower;
    }

    public void setFollower(User follower) {
        this.follower = follower;
    }

    public User getFollowed() {
        return followed;
    }

    public void setFollowed(User followed) {
        this.followed = followed;
    }

    public Date getFollow_date() {
        return follow_date;
    }

    public void setFollow_date(Date follow_date) {
        this.follow_date = follow_date;
    }
}
