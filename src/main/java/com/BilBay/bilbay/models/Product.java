package com.BilBay.bilbay.models;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.yaml.snakeyaml.DumperOptions;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JoinColumn(name = "seller_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference(value = "product-user")
    private User user;
    @Column(name = "category")
    private String category;
    @JsonManagedReference("product-spec")
    @JoinColumn(name = "product_specification_id", referencedColumnName = "id")
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL) //denna cascade funkar för inmatning
    private ProductSpecification productSpecification;
    @ManyToMany(mappedBy = "favorites", cascade = CascadeType.ALL) //Den raderar även user
    private Set<User> users = new HashSet<>();
    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "auction-product")
    private Auction auction;
    @Column(name = "product_name")
    private String productName;
    @Column(name = "original_price")
    private long originalPrice;
    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDate createdAt;
    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDate updatedAt;
    @Column(name = "is_available")
    @ColumnDefault("true")
    private Boolean isAvailable;


    public Product() {
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
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public ProductSpecification getProductSpecification() {
        return productSpecification;
    }
    public void setProductSpecification(ProductSpecification productSpecification) {
        this.productSpecification = productSpecification;
    }
    public Set<User> getUsers() {
        return users;
    }
    public void setUsers(Set<User> users) {
        this.users = users;
    }
    public Auction getAuction() {
        return auction;
    }
    public void setAuction(Auction auction) {
        this.auction = auction;
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public long getOriginalPrice() {
        return originalPrice;
    }
    public void setOriginalPrice(long originalPrice) {
        this.originalPrice = originalPrice;
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
    public Boolean getIsAvailable() {
        return isAvailable;
    }
    public void setIsAvailable(Boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
}
