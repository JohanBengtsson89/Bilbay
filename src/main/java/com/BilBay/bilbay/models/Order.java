package com.BilBay.bilbay.models;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDate;
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @OneToOne()
    @JoinColumn(name = "bid_id", referencedColumnName = "id")
    private Bid bid;
    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    private DeliveryPaymentTransaction deliveryPaymentTransaction;
    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    private PaymentTransaction paymentTransaction;
    @CreationTimestamp
    @Column(name = "registration_date")
    private LocalDate registrationDate;


    public Order() {
    }
    public DeliveryPaymentTransaction getDeliveryPaymentTransaction() {
        return deliveryPaymentTransaction;
    }
    public void setDeliveryPaymentTransaction(DeliveryPaymentTransaction deliveryPaymentTransaction) {
        this.deliveryPaymentTransaction = deliveryPaymentTransaction;
    }
    public PaymentTransaction getPaymentTransaction() {
        return paymentTransaction;
    }
    public void setPaymentTransaction(PaymentTransaction paymentTransaction) {
        this.paymentTransaction = paymentTransaction;
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
    public LocalDate getRegistrationDate() {
        return registrationDate;
    }
    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }
}
