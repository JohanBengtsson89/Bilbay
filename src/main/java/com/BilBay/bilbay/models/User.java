package com.BilBay.bilbay.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.validation.annotation.Validated;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
@Entity
@Table(name = "users")
@Validated
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "user_type")
    private UserType userType;
    @Column(name = "first_name")
    @Size(max = 50)
    private String firstName;
    @Column(name = "last_name")
    @Size(max = 50)
    private String lastName;
    @Column(name = "company_name")
    @Size(max = 50)
    private String companyName;
    @Column(name = "email_address", unique = true, nullable = false)
    @Size(max = 50)
    private String emailAddress;
    @Column(name = "organization_nr")
    private String organizationNumber;
    @Column(name = "password_hash")
    @Size(max = 50)
    private String passwordHash;
    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDate createdAt;
    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDate updatedAt;
    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private Set<Product> products = new HashSet<>();
    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private Set<Auction> auctions = new HashSet<>();
    @OneToMany(mappedBy = "buyer")
    @JsonIgnore
    private Set<Bid> bidsBuyer = new HashSet<>();
    @OneToMany(mappedBy = "userFor")
    @JsonIgnore
    private Set<Review> reviewsFor = new HashSet<>();
    @OneToMany(mappedBy = "userBy")
    @JsonIgnore
    private Set<Review> reviewsBy = new HashSet<>();
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonIgnore
    @JoinTable(name = "favorites",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id"))
    private Set<Product> favorites = new HashSet<>();
    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private Set<BankPayment> bankPayments = new HashSet<>();
    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private Set<CardPayment> cardPayments = new HashSet<>();
    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private Set<DeliveryPaymentTransaction> deliveryPaymentTransactions = new HashSet<>();
    @OneToOne(mappedBy = "user")
    @JsonIgnore
    private Address address;


    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getOrganizationNumber() {
        return organizationNumber;
    }

    public void setOrganizationNumber(String organizationNumber) {
        this.organizationNumber = organizationNumber;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public Set<Auction> getAuctions() {
        return auctions;
    }

    public void setAuctions(Set<Auction> auctions) {
        this.auctions = auctions;
    }

    public Set<Bid> getBidsBuyer() {
        return bidsBuyer;
    }

    public void setBidsBuyer(Set<Bid> bidsBuyer) {
        this.bidsBuyer = bidsBuyer;
    }

    public Set<Review> getReviewsFor() {
        return reviewsFor;
    }

    public void setReviewsFor(Set<Review> reviewsFor) {
        this.reviewsFor = reviewsFor;
    }

    public Set<Review> getReviewsBy() {
        return reviewsBy;
    }

    public void setReviewsBy(Set<Review> reviewsBy) {
        this.reviewsBy = reviewsBy;
    }

    public Set<Product> getFavorites() {
        return favorites;
    }

    public void setFavorites(Set<Product> favorites) {
        this.favorites = favorites;
    }

    public Set<BankPayment> getBankPayments() {
        return bankPayments;
    }

    public void setBankPayments(Set<BankPayment> bankPayments) {
        this.bankPayments = bankPayments;
    }

    public Set<CardPayment> getCardPayments() {
        return cardPayments;
    }

    public void setCardPayments(Set<CardPayment> cardPayments) {
        this.cardPayments = cardPayments;
    }

    public Set<DeliveryPaymentTransaction> getDeliveryPaymentTransactions() {
        return deliveryPaymentTransactions;
    }

    public void setDeliveryPaymentTransactions(Set<DeliveryPaymentTransaction> deliveryPaymentTransactions) {
        this.deliveryPaymentTransactions = deliveryPaymentTransactions;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
