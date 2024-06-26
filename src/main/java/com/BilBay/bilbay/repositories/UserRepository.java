package com.BilBay.bilbay.repositories;

import com.BilBay.bilbay.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    Optional<User> findUserByEmail(String email);

    User findUserById(Long id);

    Boolean existsByUsername(String username);
}