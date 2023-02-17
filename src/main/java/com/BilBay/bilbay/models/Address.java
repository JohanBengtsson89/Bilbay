package com.BilBay.bilbay.models;


import jakarta.persistence.*;

@Entity
@Table (name = "Address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user_id;

    @Column(name = "address")
    private String address;

    @Column(name = "telephone")
    private int telephone;

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

    public User getUser_id() {
        return user_id;
    }

    public void setUser_id(User user_id) {
        this.user_id = user_id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
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

    public Address(Long id, User user_id, String address, int telephone, String city, String country, int postal_code)
    {
        this.id = id;
        this.user_id = user_id;
        this.address = address;
        this.telephone = telephone;
        this.city = city;
        this.country = country;
        this.postal_code = postal_code;
    }
}
