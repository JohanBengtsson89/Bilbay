package com.BilBay.bilbay.controllers;


import com.BilBay.bilbay.models.Review;
import com.BilBay.bilbay.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:5173", maxAge = 3600)
@RestController
@RequestMapping("/api/")
public class ReviewController {
    @Autowired
    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping("auth/Review")
    @PreAuthorize("hasRole('PRIVATE') or hasRole('COMPANY') or hasRole('ADMIN')")
    Review createReview(@RequestBody Review review) {
        return reviewService.createReview(review);
    }
    @GetMapping("getAllReviews")
    List<Review> getAllReviews() {
        return reviewService.getAllReviews();
    }
}
