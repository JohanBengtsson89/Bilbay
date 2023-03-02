package com.BilBay.bilbay.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user_type")
public class TypeUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private ETypeUser name;
    @ManyToMany(mappedBy = "typeUsers")
    @JsonIgnore
//    @JsonBackReference("user_type_user")
    private Set<User> users = new HashSet<>();

    public TypeUser() {
    }

    public TypeUser(String typeUser) {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ETypeUser getName() {
        return name;
    }

    public void setETypeUser(ETypeUser eTypeUser) {
        this.name = eTypeUser;
    }

    public void setName(ETypeUser name) {
        this.name = name;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
