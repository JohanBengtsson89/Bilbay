package com.BilBay.bilbay.models;

import jakarta.persistence.*;
import jdk.jfr.Relational;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name = "bid")
public class Bid {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private int id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "seller_id", referencedColumnName = "id")
    private User userSeller;

    @OneToOne
    @JoinColumn(name = "buyer_id", referencedColumnName = "id")
    private User userBuyer;

    @ManyToOne
    @JoinColumn(name = "auction_id", referencedColumnName = "id")
    private Auction auction;

    @Column(name = "bid_amount")
    private Long bidAmount;

    @Column(name = "created_at")
    @CreationTimestamp
    private Date createdAt;

    public Bid() {
    }

    public Bid(int id, User userSeller, User userBuyer, Auction auction, Long bidAmount, Date createdAt) {
        this.id = id;
        this.userSeller = userSeller;
        this.userBuyer = userBuyer;
        this.auction = auction;
        this.bidAmount = bidAmount;
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUserSeller() {
        return userSeller;
    }

    public void setUserSeller(User userSeller) {
        this.userSeller = userSeller;
    }

    public User getUserBuyer() {
        return userBuyer;
    }

    public void setUserBuyer(User userBuyer) {
        this.userBuyer = userBuyer;
    }

    public Auction getAuction() {
        return auction;
    }

    public void setAuction(Auction auction) {
        this.auction = auction;
    }

    public Long getBidAmount() {
        return bidAmount;
    }

    public void setBidAmount(Long bidAmount) {
        this.bidAmount = bidAmount;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}




