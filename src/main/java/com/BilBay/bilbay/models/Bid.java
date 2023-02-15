package com.BilBay.bilbay.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "bid")
public class Bid {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private int id;

    @Column(name ="seller_id")
    private int sellerId;

    @Column(name = "buyer_id")
    private int buyerId;

    @Column(name = "auction_id")
    private int auctionId;

    @Column(name = "bid_amount")
    private int bidAmount;

    @Column(name = "created_at")
    private Date createdAt;

    public Bid() {
    }

    public Bid(int id, int sellerId, int buyerId, int auctionId, int bidAmount, Date createdAt) {
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

    public int getSellerId() {
        return sellerId;
    }

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }

    public int getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(int buyerId) {
        this.buyerId = buyerId;
    }

    public int getAuctionId() {
        return auctionId;
    }

    public void setAuctionId(int auctionId) {
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
