package com.BilBay.bilbay.models;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name = "reviews")
public class Review {

    @Id
    @Column(name = "id", nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // TODO: 2023-02-16 samma lösning som på bid
/*    @ManyToOne
    @JoinColumn(name = "users_id_by", referencedColumnName = "id")
    private User userBy; // Kan inte döpa den till user

    @ManyToOne
    @JoinColumn(name = "users_id_for", referencedColumnName = "id")
    private User userFor; // Kan inte döpa den till user*/

    @ManyToOne@JoinColumns({
            @JoinColumn(name = "user_for", referencedColumnName = "id"),
            @JoinColumn(name = "user_by", referencedColumnName = "id")})
    private User user;

    @Column(name = "comment")
    private String comment;

    @Column(name = "rate")
    private int rate;

    @Column(name = "created_at")
    @CreationTimestamp
    private Date createdAt;

    @Column(name = "updated_at")
    @CreationTimestamp
    private Date updatedAt;

    public Review() {
    }

    public Review(int id, User user, String comment, int rate, Date createdAt, Date updatedAt) {
        this.id = id;
        this.user = user;
        this.comment = comment;
        this.rate = rate;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
