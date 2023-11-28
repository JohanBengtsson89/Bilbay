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
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

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
    @OneToMany(mappedBy = "auction", cascade = CascadeType.ALL)
    @JsonIdentityReference(alwaysAsId = false)
    private Set<Bid> bids = new HashSet<>();
    @OneToMany(mappedBy = "auction", cascade = CascadeType.PERSIST, orphanRemoval = true)
    @JsonIdentityReference(alwaysAsId = true)
    @JsonIgnore
    private Set<Favorite> favorites;
    @Column(name = "product_name")
    private String productName;
    @Column(name = "product_photo")
    private String productPhoto;
    @Column(name = "category")
    private String category;
    @Column(name = "original_price")
    private int originalPrice;
    @Column(name = "model_year")
    private int modelYear;
    @Column(name = "gear")
    private String gear;
    @Column(name = "engine_power")
    private int enginePower;
    @Column(name = "color")
    private String color;
    @Column(name = "mileage")
    private int mileage;
    @Column(name = "VIN_nr")
    private String vinNr;
    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDate createdAt;
    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDate updatedAt;
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

    public static class Builder {
        private final User user;
        private final String productName;
        private String productPhoto;
        private final String category;
        private int originalPrice;
        private int modelYear;
        private String gear;
        private int enginePower;
        private String color;
        private int mileage;
        private String vinNr;
        private int reservePrice;
        private final int startPrice;
        private final LocalDate startTime;
        private final LocalDate endTime;
        private boolean active;

        //Builder pattern implementation
        public Builder(User user,String productName, String category, int startPrice, LocalDate startTime, LocalDate endTime){
            this.productName = productName;
            this.user = user;
            this.category = category;
            this.startPrice = startPrice;
            this.startTime = startTime;
            this.endTime = endTime;
        }

        public Builder color (String color){
            this.color = color;
            return this;
        }
        public Builder vinNr (String vinNr) {
            this.vinNr = vinNr;
            return this;
        }
        public Builder reservePrice (int reservePrice) {
            this.reservePrice = reservePrice;
            return this;
        }
        public Builder mileage (int mileage) {
            this.mileage = mileage;
            return this;
        }
        public Builder productPhoto (String productPhoto) {
            this.productPhoto = productPhoto;
            return this;
        }
        public Builder originalPrice (int originalPrice) {
            this.originalPrice = originalPrice;
            return this;
        }
        public Builder modelYear (int modelYear) {
            this.modelYear = modelYear;
            return this;
        }
        public Builder gear (String gear) {
            this.gear = gear;
            return this;
        }
        public Builder enginePower (int enginePower) {
            this.enginePower = enginePower;
            return this;
        }
        public Builder active (boolean active) {
            this.active = active;
            return this;
        }
        public Auction build() {
            Auction auction = new Auction();
            auction.user = this.user;
            auction.productName = this.productName;
            auction.category = this.category;
            auction.color = this.color;
            auction.endTime = this.endTime;
            auction.originalPrice = this.originalPrice;
            auction.active = this.active;
            auction.gear = this.gear;
            auction.enginePower = this.enginePower;
            auction.modelYear = this.modelYear;
            auction.startPrice = this.startPrice;
            auction.startTime = this.startTime;
            auction.reservePrice = this.reservePrice;
            auction.vinNr = this.vinNr;
            auction.productPhoto = this.productPhoto;
            auction.mileage = this.mileage;
            return auction;
        }
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
    public Set<Bid> getBids() {
        return bids;
    }
    public void setBids(Set<Bid> bids) {
        this.bids = bids;
    }
    public Set<Favorite> getFavorites() {
        return favorites;
    }
    public void setFavorites(Set<Favorite> favorites) {
        this.favorites = favorites;
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public String getProductPhoto() {
        return productPhoto;
    }
    public void setProductPhoto(String productPhoto) {
        this.productPhoto = productPhoto;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public int getOriginalPrice() {
        return originalPrice;
    }
    public void setOriginalPrice(int originalPrice) {
        this.originalPrice = originalPrice;
    }
    public int getModelYear() {
        return modelYear;
    }
    public void setModelYear(int modelYear) {
        this.modelYear = modelYear;
    }
    public String getGear() {
        return gear;
    }
    public void setGear(String gear) {
        this.gear = gear;
    }
    public int getEnginePower() {
        return enginePower;
    }
    public void setEnginePower(int enginePower) {
        this.enginePower = enginePower;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public int getMileage() {
        return mileage;
    }
    public void setMileage(int mileage) {
        this.mileage = mileage;
    }
    public String getVinNr() {
        return vinNr;
    }
    public void setVinNr(String vinNr) {
        this.vinNr = vinNr;
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
