package com.BilBay.bilbay.models;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "order")
    @JsonBackReference("order")
    private DeliveryPaymentTransaction deliveryPaymentTransaction;
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
