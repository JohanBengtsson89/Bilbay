package com.BilBay.bilbay.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "reviews")
public class Reviews {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "users_id_by")
    @ManyToOne
    @JoinColumn(name = "users_id_by", referencedColumnName = "id")
    private User usersIdBy;

    @Column(name = "users_id_for")
    @ManyToMany
    @JoinColumn(name = "users_id_for", referencedColumnName = "id")
    private User usersIdFor;

    @Column(name = "comment")
    private String comment;

    @Column(name = "rate")
    private int rate;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    public Reviews() {
    }

    public Reviews(int id, User usersIdBy, User usersIdFor, String comment, int rate, Date createdAt, Date updatedAt) {
        this.id = id;
        this.usersIdBy = usersIdBy;
        this.usersIdFor = usersIdFor;
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

    public User getUsersIdBy() {
        return usersIdBy;
    }

    public void setUsersIdBy(User usersIdBy) {
        this.usersIdBy = usersIdBy;
    }

    public User getUsersIdFor() {
        return usersIdFor;
    }

    public void setUsersIdFor(User usersIdFor) {
        this.usersIdFor = usersIdFor;
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
