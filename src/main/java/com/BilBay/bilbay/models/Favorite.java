package com.BilBay.bilbay.models;

import jakarta.persistence.*;
import org.yaml.snakeyaml.events.Event;

@Entity
@Table (name = "Favorite")
public class Favorite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private long id;


    @ManyToMany
    @Column (name = "User_id")
    private String user_id;

    @Column (name = "product id")
    private String product_id;
    public Favorite() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public Favorite(long id, String user_id, String product_id) {
        this.id = id;
        this.user_id = user_id;
        this.product_id = product_id;
    }


}
