package com.example.cs5610fall2020projectteam23serverjava.services;

//import com.example.cs5610fall2020projectteam23serverjava.models.Administrator;

import com.example.cs5610fall2020projectteam23serverjava.models.Review;
import com.example.cs5610fall2020projectteam23serverjava.models.User;
import com.example.cs5610fall2020projectteam23serverjava.repositories.ReviewRepository;
import com.example.cs5610fall2020projectteam23serverjava.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserReviewService {
    @Autowired
    ReviewRepository reviewRepository;
    @Autowired
    UserRepository userRepository;

    public User addReviewToUser(
            Integer reviewId,
            Integer userId) {
        User user   = userRepository.findById(userId).get();
        Review review = reviewRepository.findById(reviewId).get();
        user.getReviews().add(review);
        review.setUser(user);
        reviewRepository.save(review);
        return user;
    }





    public Review findReviewById (Integer reviewId) {
        return reviewRepository.findById(reviewId).get();
    }

    public List<Review> findAllReview() {
        return (List<Review>) reviewRepository.findAll();
    }

    public Review createReview (Integer userId, Review review) {
        Review reviewTemp = reviewRepository.save(review);
        this.addReviewToUser(reviewTemp.getReviewId(), userId);

        return findReviewById(reviewTemp.getReviewId());
    }

    public Review updateReview(
            Review newReview) {

        Optional newReviewTemp = reviewRepository.findById(newReview.getReviewId());
        if(newReviewTemp.isPresent()) {
            Review review = (Review) newReviewTemp.get();
            review.setReviewContent(newReview.getReviewContent());
            review.setUser(newReview.getUser());
            return reviewRepository.save(review);
        } else {
            return null;
        }
    }

    public void deleteReview(
            Integer reviewId) {
        reviewRepository.deleteById(reviewId);
    }




}
