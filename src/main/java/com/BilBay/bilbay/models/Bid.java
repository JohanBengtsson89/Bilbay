package com.BilBay.bilbay.models;
import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import jdk.jfr.Relational;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDate;
import java.util.Date;
@Entity
@Table(name = "bid")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = Bid.class)
public class Bid {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // Ändrade här enligt överenskommelse - Johan
    @ManyToOne
    @JoinColumn(name = "buyer_id", referencedColumnName = "id")
    @JsonIdentityReference(alwaysAsId = true)
    private User buyer;
    @OneToOne(mappedBy = "bid", cascade = CascadeType.ALL)
    @JsonIdentityReference(alwaysAsId = true)
    private Order order;
    @ManyToOne
    @JoinColumn(name = "auction_id", referencedColumnName = "id")
    @JsonIdentityReference(alwaysAsId = true)
    private Auction auction;
    @Column(name = "bid_amount")
    private Long bidAmount;
    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDate createdAt;


    public Bid() {
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
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
    public LocalDate getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }
    public Order getOrder() {
        return order;
    }
    public void setOrder(Order order) {
        this.order = order;
    }
}




