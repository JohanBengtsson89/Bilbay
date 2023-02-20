package com.BilBay.bilbay.models;

import jakarta.persistence.*;
import org.yaml.snakeyaml.events.Event;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table (name = "favorite")
public class Favorite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;


    @ManyToMany(mappedBy = "favorites")
    private Set<User> users = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "favorite_products",
            joinColumns = @JoinColumn(name = "favorite_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id"))
    private Set<Product> products = new HashSet<>();

    public Favorite(Long id, Set<User> users, Set<Product> products) {
        this.id = id;
        this.users = users;
        this.products = products;

    }
    public Favorite() {

    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

}


