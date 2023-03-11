package com.BilBay.bilbay.models;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.*;
@Entity
@Table(name = "card_payment")
public class CardPayment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @JsonBackReference(value= "cardPayment-user")
    private User user;
    @Column(name = "card_type")
    private String cardType;
    @Column(name = "card_number")
    private long cardNumber;
    @Column(name = "expire_date")
    private Date expireDate;    // Manuell inmatning, kan behöva byta datatyp - Johan
    @Column(name = "cvv")
    private int cvv;
    @OneToMany(mappedBy = "cardPayment")
    @JsonIgnore
    @JsonManagedReference(value = "card-deliver")
    private Set<DeliveryPaymentTransaction> deliveryPaymentTransactions= new HashSet<>();
    @OneToMany(mappedBy = "cardPayment")
    @JsonIgnore
    @JsonManagedReference(value = "card-transaction")
    private Set<PaymentTransaction> paymentTransaction;

    public CardPayment() {
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
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
    public Set<DeliveryPaymentTransaction> getDeliveryPaymentTransactions() {
        return deliveryPaymentTransactions;
    }
    public void setDeliveryPaymentTransactions(Set<DeliveryPaymentTransaction> deliveryPaymentTransactions) {
        this.deliveryPaymentTransactions = deliveryPaymentTransactions;
    }
    public Set<PaymentTransaction> getPaymentTransaction() {
        return paymentTransaction;
    }
    public void setPaymentTransaction(Set<PaymentTransaction> paymentTransaction) {
        this.paymentTransaction = paymentTransaction;
    }
}

