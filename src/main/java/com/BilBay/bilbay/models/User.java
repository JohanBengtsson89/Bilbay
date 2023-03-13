package com.BilBay.bilbay.models;


import com.fasterxml.jackson.annotation.*;
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
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = User.class)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private Set<Role> roles = new HashSet<>();
    @Column(name = "first_name")
    @Size(max = 50)
    private String firstName;
    @Column(name = "last_name")
    @Size(max = 50)
    private String lastName;
    @Column(name = "company_name")
    @Size(max = 50)
    private String companyName;
    @Column(name = "email", unique = true, nullable = false)
    @Size(max = 50)
    private String email;
    @Column(name = "username")
    private String username;
    @Column(name = "organization_nr")
    private String organizationNumber;
    @Column(name = "password")
    @Size(min = 1, max = 120, message = "Lösenord måste vara mellan {min} och {max} tecken långt.")
    private String password;
    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDate createdAt;
    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDate updatedAt;
    
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIdentityReference(alwaysAsId = true)
    private Set<Product> products = new HashSet<>();
    
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIdentityReference(alwaysAsId = true)
    private Set<Auction> auctions = new HashSet<>();
    
    @OneToMany(mappedBy = "buyer", cascade = CascadeType.ALL)
    @JsonIdentityReference(alwaysAsId = true)
    private Set<Bid> bidsBuyer = new HashSet<>();
    
    @OneToMany(mappedBy = "userFor")
    @JsonIdentityReference(alwaysAsId = true)
    private Set<Review> reviewsFor = new HashSet<>();
    
    @OneToMany(mappedBy = "userBy")
    @JsonIdentityReference(alwaysAsId = true)
    private Set<Review> reviewsBy = new HashSet<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST, orphanRemoval = true)
    @JsonManagedReference("favorites")
    @JsonIgnore
    private Set<Favorite> favorites;
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIdentityReference(alwaysAsId = true)
    private Set<BankPayment> bankPayments = new HashSet<>();
    
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIdentityReference(alwaysAsId = true)
    private Set<CardPayment> cardPayments = new HashSet<>();
    
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIdentityReference(alwaysAsId = true)
    private Set<DeliveryPaymentTransaction> deliveryPaymentTransactions = new HashSet<>();
    
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIdentityReference(alwaysAsId = true)
    private Address address;
    
    @JsonIdentityReference(alwaysAsId = true)
    @OneToMany(mappedBy = "buyer")
    private Set<PaymentTransaction> paymentTransactions= new HashSet<>();

    public void setId(Long id) {
        this.id = id;
    }


    public User() {
    }
    public User(String firstName, String lastName, String email, String username, String password, String companyName, String organizationNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.password = password;
        this.companyName = companyName;
        this.organizationNumber = organizationNumber;
    }
    public Long getId() {
        return id;
    }

    public Set<Role> getRoles() {
        return roles;
    }
    public void setRoles(Set<Role> roles) {
        this.roles = roles;

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
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getOrganizationNumber() {
        return organizationNumber;
    }
    public void setOrganizationNumber(String organizationNumber) {
        this.organizationNumber = organizationNumber;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
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
    public Set<PaymentTransaction> getPaymentTransactions() {
        return paymentTransactions;
    }
    public void setPaymentTransactions(Set<PaymentTransaction> paymentTransactions) {
        this.paymentTransactions = paymentTransactions;
    }

    public Set<Favorite> getFavorites() {
        return favorites;
    }

    public void setFavorites(Set<Favorite> favorites) {
        this.favorites = favorites;
    }
}
