package com.BilBay.bilbay.serviceImpl;

import com.BilBay.bilbay.models.Review;
import com.BilBay.bilbay.repositories.ReviewRepository;
import com.BilBay.bilbay.services.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

private ReviewRepository reviewRepository;

    @Override
    public Review createReview(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public List <Review> getAllReviews() {
        return reviewRepository.findAll();
    }
}
