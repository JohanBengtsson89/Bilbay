package com.BilBay.bilbay.models;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDate;
@Entity
@Table(name = "payment_transaction")
public class PaymentTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "buyer_id", referencedColumnName = "id")
    @JsonBackReference(value = "payment-user")
    private User buyer;
    @OneToOne
    @JoinColumn(name = "orders_id", referencedColumnName = "id")
    private Order order;
    @OneToOne
    @JoinColumn(name = "bid_id", referencedColumnName = "id")
    private Bid bid;
    @ManyToOne
    @JoinColumn(name = "card_payment_id", referencedColumnName = "id")
    private CardPayment cardPayment;
    @ManyToOne()
    @JoinColumn(name = "bank_payment_id", referencedColumnName = "id")
    private BankPayment bankPayment;
    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDate createdAt;
    @Column(name = "is_successful")
    @ColumnDefault("false")
    private boolean successful;


    public PaymentTransaction() {
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
        return successful;
    }
    public void setSuccessful(boolean successful) {
        this.successful = successful;
    }

    @Override
    public String toString() {
        return "PaymentTransaction{" +
                "buyer=" + buyer +
                '}';
    }
}
