package com.BilBay.bilbay.models;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.*;
@Entity
@Table(name = "bank_payment")
public class BankPayment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JoinColumn(name = "users_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.REMOVE,
            CascadeType.DETACH})
    @JsonBackReference(value = "bankPayment-user")
    private User user;
    @Column(name = "bank_name")
    private String bankName;
    @Column(name = "bank_account_nr")
    private Long bankAccountNr;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "bankPayment")
    private Set< PaymentTransaction > paymentTransactions = new HashSet<>();


    public BankPayment() {
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
    public String getBankName() {
        return bankName;
    }
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
    public Long getBankAccountNr() {
        return bankAccountNr;
    }
    public void setBankAccountNr(Long bankAccountNr) {
        this.bankAccountNr = bankAccountNr;
    }
    public Set<PaymentTransaction> getPaymentTransactions() {
        return paymentTransactions;
    }
    public void setPaymentTransactions(Set<PaymentTransaction> paymentTransactions) {
        this.paymentTransactions = paymentTransactions;
    }
}
