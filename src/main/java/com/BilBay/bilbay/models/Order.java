package com.BilBay.bilbay.models;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDate;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bid_id", referencedColumnName = "id")
    private Bid bid;

    @CreationTimestamp
    @Column(name = "registration_date")
    private LocalDate registrationName;

    public Order() {
    }

    public Order(Long id, Bid bid, LocalDate registrationName) {
        this.id = id;
        this.bid = bid;
        this.registrationName = registrationName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Bid getBid() {
        return bid;
    }

    public void setBid(Bid bid) {
        this.bid = bid;
    }

    public LocalDate getRegistrationName() {
        return registrationName;
    }

    public void setRegistrationName(LocalDate registrationName) {
        this.registrationName = registrationName;
    }
}
