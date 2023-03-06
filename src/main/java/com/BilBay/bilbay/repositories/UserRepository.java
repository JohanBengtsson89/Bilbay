package com.BilBay.bilbay.repositories;

import com.BilBay.bilbay.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByEmailAndPassword(String username, String password);

    Optional<User> findUserByEmail(String email);

    User findUserById(Long id);

    Boolean existsByEmail(String email);

//    Optional<Object> findByEmailAddress(String email);
}