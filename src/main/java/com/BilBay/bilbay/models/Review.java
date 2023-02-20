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
    private Long id;

    // Ändrade här enligt överenskomlse - Johan
    @ManyToOne
    @JoinColumn(name = "users_id_by", referencedColumnName = "id")
    private User userBy; // Kan inte döpa den till user

    @ManyToOne
    @JoinColumn(name = "users_id_for", referencedColumnName = "id")
    private User userFor; // Kan inte döpa den till user

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

    public Review(Long id, User userBy, User userFor, String comment, int rate, Date createdAt, Date updatedAt) {
        this.id = id;
        this.userBy = userBy;
        this.userFor = userFor;
        this.comment = comment;
        this.rate = rate;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUserBy() {
        return userBy;
    }

    public void setUserBy(User userBy) {
        this.userBy = userBy;
    }

    public User getUserFor() {
        return userFor;
    }

    public void setUserFor(User userFor) {
        this.userFor = userFor;
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
