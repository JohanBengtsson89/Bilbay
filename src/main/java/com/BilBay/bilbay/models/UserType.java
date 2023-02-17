package com.BilBay.bilbay.models;

import jakarta.persistence.*;

@Entity
@Table(name = "User_type")
public class UserType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "name")
    @OneToMany
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserType() {
    }
    public UserType(Long id, String name) {
        this.id = id;
        this.name = name;
    }


}