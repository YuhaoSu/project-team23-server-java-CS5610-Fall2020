package com.example.cs5610fall2020projectteam23serverjava.controllers;

import com.example.cs5610fall2020projectteam23serverjava.models.Review;
import com.example.cs5610fall2020projectteam23serverjava.models.User;
import com.example.cs5610fall2020projectteam23serverjava.services.UserMovieReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins = "*")
@CrossOrigin(origins = "http://cs5610-client-react-team23.herokuapp.com", allowCredentials = "true")
public class ReviewController {
    @Autowired
    UserMovieReviewService service;

    @GetMapping("/api/reviews/{userId}/for/{movieId}")
    public Review findReviewById(
            @PathVariable("userId") Integer userId,
            @PathVariable("movieId") Integer movieId) {
        return service.findReviewById(userId, movieId);
    }

    @GetMapping("/api/reviews")
    public List<Review> findAllReview() {
        return service.findAllReview();
    }

   @PostMapping("/api/reviews/{userId}/for/{movieId}")
    public Review createReview(
            @PathVariable("userId") Integer userId,
            @PathVariable("movieId") Integer movieId,
            @RequestBody Review newReview) {
        return service.createReview(userId, movieId, newReview);
    }

    @PutMapping("/api/reviews/{userId}/for/{movieId}")
    public Review updateReviews(
            @PathVariable("userId") Integer userId,
            @PathVariable("movieId") Integer movieId,
            @RequestBody Review newReview) {
        return service.updateReview(userId, movieId, newReview);
    }

    @DeleteMapping("/api/reviews/{userId}/for/{movieId}")
    public void deleteReview(
            @PathVariable("userId") Integer userId,
            @PathVariable("movieId") Integer movieId) {
        service.deleteReview(userId, movieId);
    }

    @GetMapping("/api/reviews/{movieId}")
    public List<Review> findReviewsByMovieID(
            @PathVariable("movieId") Integer movieId) {
       return service.findReviewsByMovieID(movieId);
    }

}
