package com.BilBay.bilbay.models;
import java.util.*;
import jakarta.persistence.*;

@Entity
@Table(name = "users_type")
public class TypeUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "name")
    private String name;

    @OneToMany(mappedBy = "typeUser")
    private List<User> users= new ArrayList<>();

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

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public TypeUser() {
    }
    public TypeUser(Long id, String name, List<User> users) {
        this.id = id;
        this.name = name;
        this.users = users;
    }
}