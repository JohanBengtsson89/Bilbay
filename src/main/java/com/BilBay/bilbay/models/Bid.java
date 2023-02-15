package com.BilBay.bilbay.models;

import jakarta.persistence.*;
import jdk.jfr.Relational;

import java.util.Date;

@Entity
@Table(name = "bid")
public class Bid {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private int id;


    @Column(name = "seller_id")
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "seller_id", referencedColumnName = "id")
    private User sellerId;

    @Column(name = "buyer_id")
    @OneToOne
    @JoinColumn(name = "buyer_id", referencedColumnName = "id")
    private User buyerId;

    @Column(name = "auction_id")
    @ManyToOne
    @JoinColumn(name = "auction_id", referencedColumnName = "id")
    private Auction auctionId;

    @Column(name = "bid_amount")
    private int bidAmount;

    @Column(name = "created_at")
    @Temporal(TemporalType.DATE)
    private Date createdAt;

    public Bid() {
    }

    public Bid(int id, User sellerId, User buyerId, Auction auctionId, int bidAmount, Date createdAt) {
        this.id = id;
        this.sellerId = sellerId;
        this.buyerId = buyerId;
        this.auctionId = auctionId;
        this.bidAmount = bidAmount;
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getSellerId() {
        return sellerId;
    }

    public void setSellerId(User sellerId) {
        this.sellerId = sellerId;
    }

    public User getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(User buyerId) {
        this.buyerId = buyerId;
    }

    public Auction getAuctionId() {
        return auctionId;
    }

    public void setAuctionId(Auction auctionId) {
        this.auctionId = auctionId;
    }

    public int getBidAmount() {
        return bidAmount;
    }

    public void setBidAmount(int bidAmount) {
        this.bidAmount = bidAmount;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}


