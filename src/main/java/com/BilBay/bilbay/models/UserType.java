package com.BilBay.bilbay.models;

import jakarta.persistence.*;

@Entity
@Table(name = "User_type")

public class UserType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
}
