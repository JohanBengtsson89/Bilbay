package com.BilBay.bilbay.models;

import jakarta.persistence.*;

@Entity
@Table(name = "bank_payment")
public class BankPayment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @JoinColumn(name = "users_id", referencedColumnName = "id")
    @ManyToOne(cascade = CascadeType.ALL)
    private User user;

    @Column(name = "bank_name")
    private String bankName;

    @Column(name = "bank_account_nr")
    private Long bankAccountNr;

    @OneToMany(mappedBy = "bankPayment")
    private List < PaymentTransaction > paymentTransactions = new ArrayList<>();

    public BankPayment() {
    }

    public BankPayment(int id, User user, String bankName, Long bankAccountNr, List<PaymentTransaction> paymentTransactions) {
        this.id = id;
        this.user = user;
        this.bankName = bankName;
        this.bankAccountNr = bankAccountNr;
        this.paymentTransactions = paymentTransactions;
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

    public Long getBankAccountNr() {
        return bankAccountNr;
    }

    public void setBankAccountNr(Long bankAccountNr) {
        this.bankAccountNr = bankAccountNr;
    }

    public List<PaymentTransaction> getPaymentTransactions() {
        return paymentTransactions;
    }

    public void setPaymentTransactions(List<PaymentTransaction> paymentTransactions) {
        this.paymentTransactions = paymentTransactions;
    }
}
