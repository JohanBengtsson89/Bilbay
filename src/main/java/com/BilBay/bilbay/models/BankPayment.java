package com.BilBay.bilbay.models;

import jakarta.persistence.*;

@Entity
@Table(name = "bank_payment")
public class BankPayment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "users_id")
    @OneToOne
    @JoinColumn(name = "users_id, ", referencedColumnName = "id")
    private User user;

    @Column(name = "bank_name")
    private String bankName;

    @Column(name = "bank_account_nr")
    private String bankAccountNr;

    public BankPayment() {
    }

    public BankPayment(int id, User user, String bankName, String bankAccountNr) {
        this.id = id;
        this.user = user;
        this.bankName = bankName;
        this.bankAccountNr = bankAccountNr;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getBankAccountNr() {
        return bankAccountNr;
    }

    public void setBankAccountNr(String bankAccountNr) {
        this.bankAccountNr = bankAccountNr;
    }
}
