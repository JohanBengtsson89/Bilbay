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
    private int original_price;
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
    private String createdAt;
    @Column(name = "updated_at")
    private String updatedAt;
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
}
