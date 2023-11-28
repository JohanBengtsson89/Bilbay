package com.BilBay.bilbay.services;

import com.BilBay.bilbay.models.Review;
import com.BilBay.bilbay.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReviewService {
  Review createReview (Review review);
  List <Review> getAllReviews();

}
