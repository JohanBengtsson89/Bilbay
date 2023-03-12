package com.BilBay.bilbay.models;
import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;

import java.util.*;
@Entity
@Table(name = "bank_payment")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = BankPayment.class)
public class BankPayment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JoinColumn(name = "users_id", referencedColumnName = "id")
    @ManyToOne
    @JsonIdentityReference(alwaysAsId = true)
    private User user;
    @Column(name = "bank_name")
    private String bankName;
    @Column(name = "bank_account_nr")
    private Long bankAccountNr;
    @OneToMany(mappedBy = "bankPayment")
    @JsonIgnore
    @JsonIdentityReference(alwaysAsId = true)
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
