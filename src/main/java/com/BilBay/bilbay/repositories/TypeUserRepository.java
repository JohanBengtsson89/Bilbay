package com.BilBay.bilbay.repositories;

import com.BilBay.bilbay.models.TypeUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeUserRepository extends JpaRepository<TypeUser, Long> {
}