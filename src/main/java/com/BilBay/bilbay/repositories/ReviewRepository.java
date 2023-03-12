package com.BilBay.bilbay.repositories;

import com.BilBay.bilbay.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}