package com.BilBay.bilbay.models;
import jakarta.persistence.*;
@Entity
@Table (name = "Address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "users_id", referencedColumnName = "id")
    private User user;
    @Column(name = "address")
    private String address;
    @Column(name = "telephone")
    private Long telephone;
    @Column (name = "city")
    private String city;
    @Column (name = "country")
    private String country;
    @Column (name = "postal_code")
    private int postal_code;


    public Address() {
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
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public Long getTelephone() {
        return telephone;
    }
    public void setTelephone(Long telephone) {
        this.telephone = telephone;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public int getPostal_code() {
        return postal_code;
    }
    public void setPostal_code(int postal_code) {
        this.postal_code = postal_code;
    }
}
