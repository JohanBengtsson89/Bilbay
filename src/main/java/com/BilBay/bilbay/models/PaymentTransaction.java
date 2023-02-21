package com.BilBay.bilbay.models;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDate;

@Entity
@Table(name = "payment_transaction")
public class PaymentTransaction {
    @Id
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "orders_id", referencedColumnName = "id")
    private Order order;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bid_id", referencedColumnName = "id")
    private Bid bid;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "card_payment_id", referencedColumnName = "id")
    private CardPayment cardPayment;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bank_payment_id", referencedColumnName = "id")
    private BankPayment bankPayment;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDate createdAt;

    @Column(name = "is_successful")
    @ColumnDefault("false")
    private boolean isSuccessful;

    public PaymentTransaction() {
    }

    public PaymentTransaction(Long id, Order order, Bid bid, CardPayment cardPayment, BankPayment bankPayment, LocalDate createdAt, boolean isSuccessful) {
        this.id = id;
        this.order = order;
        this.bid = bid;
        this.cardPayment = cardPayment;
        this.bankPayment = bankPayment;
        this.createdAt = createdAt;
        this.isSuccessful = isSuccessful;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Bid getBid() {
        return bid;
    }

    public void setBid(Bid bid) {
        this.bid = bid;
    }

    public CardPayment getCardPayment() {
        return cardPayment;
    }

    public void setCardPayment(CardPayment cardPayment) {
        this.cardPayment = cardPayment;
    }

    public BankPayment getBankPayment() {
        return bankPayment;
    }

    public void setBankPayment(BankPayment bankPayment) {
        this.bankPayment = bankPayment;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public boolean isSuccessful() {
        return isSuccessful;
    }

    public void setSuccessful(boolean successful) {
        isSuccessful = successful;
    }
}
