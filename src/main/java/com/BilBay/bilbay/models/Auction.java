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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import org.hibernate.annotations.ColumnDefault;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
@Entity
@Table(name = "auction")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = Auction.class)
public class Auction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "seller_id", referencedColumnName = "id")
    @JsonIdentityReference(alwaysAsId = true)
    private User user;
    @OneToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    @JsonIdentityReference(alwaysAsId = false)
    private Product product;
    @OneToMany(mappedBy = "auction", cascade = CascadeType.ALL)
    @JsonIdentityReference(alwaysAsId = false)
    private Set<Bid> bids = new HashSet<>();
    @OneToMany(mappedBy = "auction", cascade = CascadeType.PERSIST, orphanRemoval = true)
    @JsonIdentityReference(alwaysAsId = true)
    @JsonIgnore
    private Set<Favorite> favorites;
    @Column(name = "reserve_price")
    private int reservePrice;
    @Column(name = "start_price")
    private int startPrice;
    @Column(name = "start_time")
    private LocalDate startTime;
    @Column(name = "end_time")
    private LocalDate endTime;
    @Column(name = "active")
    @ColumnDefault("false")
    private boolean active;


    public Auction() {
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
    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
    public Set<Favorite> getFavorites() {
        return favorites;
    }
    public void setFavorites(Set<Favorite> favorites) {
        this.favorites = favorites;
    }
    public Set<Bid> getBids() {
        return bids;
    }
    public void setBids(Set<Bid> bids) {
        this.bids = bids;
    }
    public int getReservePrice() {
        return reservePrice;
    }
    public void setReservePrice(int reservePrice) {
        this.reservePrice = reservePrice;
    }
    public int getStartPrice() {
        return startPrice;
    }
    public void setStartPrice(int startPrice) {
        this.startPrice = startPrice;
    }
    public LocalDate getStartTime() {
        return startTime;
    }
    public void setStartTime(LocalDate startTime) {
        this.startTime = startTime;
    }
    public LocalDate getEndTime() {
        return endTime;
    }
    public void setEndTime(LocalDate endTime) {
        this.endTime = endTime;
    }
    public boolean isActive() {
        return active;
    }
    public void setActive(boolean active) {
        this.active = active;
    }
}
