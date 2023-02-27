package com.BilBay.bilbay.repositories;

import com.BilBay.bilbay.models.User;
import jakarta.persistence.OneToOne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByEmailAddressAndPasswordHash(String username, String password);

    User findByEmailAddress(String email);
}