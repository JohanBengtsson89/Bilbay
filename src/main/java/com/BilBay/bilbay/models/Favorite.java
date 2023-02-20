package com.BilBay.bilbay.models;

import jakarta.persistence.*;
import org.yaml.snakeyaml.events.Event;

import java.util.HashSet;

@Entity
@Table (name = "favorite")
public class Favorite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private long id;


    @ManyToMany
    @JoinColumn (name = "user_id", referencedColumnName = "id")
    private set<user> users = new HashSet<>();

    @ManyToMany
    @JoinColumn (name = "product_id",referencedColumnName = "id")
    private Set<Product> products = new HashSet<>();

    public Favorite() {


    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public set<user> getUsers() {
        return users;
    }

    public void setUsers(set<user> users) {
        this.users = users;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public Favorite(long id, set<user> users, Set<Product> products) {
        this.id = id;
        this.users = users;
        this.products = products;
    }

}


