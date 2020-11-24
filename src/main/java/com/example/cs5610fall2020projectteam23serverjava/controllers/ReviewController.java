package com.example.cs5610fall2020projectteam23serverjava.controllers;

import com.example.cs5610fall2020projectteam23serverjava.models.Review;
import com.example.cs5610fall2020projectteam23serverjava.services.UserMovieReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ReviewController {
    @Autowired
    UserMovieReviewService service;

    @GetMapping("/api/reviews/{reviewId}")
    public Review findReviewById(
            @PathVariable("reviewId") Integer id) {
        return service.findReviewById(id);
    }

    @GetMapping("/api/reviews")
    public List<Review> findAllReview() {
        return service.findAllReview();
    }

    @PostMapping("/api/reviews/{userId}/{movieId}")
    public Review createReview(
            @PathVariable("userId") Integer userId,
            @PathVariable("movieId") Integer movieId,
            @RequestBody Review review) {
        return service.createReview(userId, review, movieId);
    }

    @PutMapping("/api/reviews")
    public Review updateReviews(
            @RequestBody Review newReview) {
        return service.updateReview(newReview);
    }

    @DeleteMapping("/api/reviews/{reviewId}")
    public void deleteReview(
            @PathVariable("reviewId") Integer reviewId) {
        service.deleteReview(reviewId);
    }
}
