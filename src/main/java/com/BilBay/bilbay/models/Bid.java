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


    // TODO: 2023-02-16 osäker om detta funkar
/*    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "seller_id", referencedColumnName = "id")
    private User seller;

    @OneToOne
    @JoinColumn(name = "buyer_id", referencedColumnName = "id")
    private User buyer;*/

    @ManyToOne@JoinColumns({
            @JoinColumn(name = "buyer_id", referencedColumnName = "id"),
            @JoinColumn(name = "seller_id", referencedColumnName = "id")})
    private User user;

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

    public Bid(int id, User user, Auction auction, Long bidAmount, Date createdAt) {
        this.id = id;
        this.user = user;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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




