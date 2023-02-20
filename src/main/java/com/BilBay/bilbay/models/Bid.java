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
    private Long id;


    // Ändrade här enligt överenskommelse - Johan
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "buyer_id", referencedColumnName = "id")
    private User buyer;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "auction_id", referencedColumnName = "id")
    private Auction auction;

    @Column(name = "bid_amount")
    private Long bidAmount;

    @Column(name = "created_at")
    @CreationTimestamp
    private Date createdAt;

    public Bid() {
    }

    public Bid(Long id, User seller, User buyer, Auction auction, Long bidAmount, Date createdAt) {
        this.id = id;
//        this.seller = seller;
        this.buyer = buyer;
        this.auction = auction;
        this.bidAmount = bidAmount;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    public User getSeller() {
//        return seller;
//    }
//
//    public void setSeller(User seller) {
//        this.seller = seller;
//    }

    public User getBuyer() {
        return buyer;
    }

    public void setBuyer(User buyer) {
        this.buyer = buyer;
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




