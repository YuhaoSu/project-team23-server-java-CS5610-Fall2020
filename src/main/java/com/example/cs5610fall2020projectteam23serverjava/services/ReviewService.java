/*
package com.example.cs5610fall2020projectteam23serverjava.services;

import com.example.cs5610fall2020projectteam23serverjava.models.Review;
import com.example.cs5610fall2020projectteam23serverjava.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {
    @Autowired
    ReviewRepository reviewRepository;

    public Review findReviewById (Integer reviewId) {
        return reviewRepository.findById(reviewId).get();
    }

    public List<Review> findAllReview() {
        return (List<Review>) reviewRepository.findAll();
    }

    public Review createReview (Review review) {
        return reviewRepository.save(review);
    }

   */
/* public Review updateReview(
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
    }*//*


    public void deleteReview(
            Integer reviewId) {
        reviewRepository.deleteById(reviewId);
    }
}
*/
