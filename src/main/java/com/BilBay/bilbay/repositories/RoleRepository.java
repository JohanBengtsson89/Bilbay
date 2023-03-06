package com.BilBay.bilbay.repositories;

import com.BilBay.bilbay.models.ERole;
import com.BilBay.bilbay.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}