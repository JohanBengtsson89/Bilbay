package com.BilBay.bilbay.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "card_payment")
public class CardPayment {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "user_id")
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User userId;

    @Column(name = "card_type")
    private String cardType;

    @Column(name = "card_number")
    private long cardNumber;

    @Column(name = "expire_date")
    private Date expireDate;

    @Column(name = "cvv")
    private int cvv;

    public CardPayment() {
    }

    public CardPayment(int id, User userId, String cardType, long cardNumber, Date expireDate, int cvv) {
        this.id = id;
        this.userId = userId;
        this.cardType = cardType;
        this.cardNumber = cardNumber;
        this.expireDate = expireDate;
        this.cvv = cvv;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }
}
