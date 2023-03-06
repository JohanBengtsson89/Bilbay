package com.BilBay.bilbay.repositories;

import com.BilBay.bilbay.models.ERole;
import com.BilBay.bilbay.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(ERole name);
}