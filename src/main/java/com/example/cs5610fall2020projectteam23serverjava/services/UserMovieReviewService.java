package com.example.cs5610fall2020projectteam23serverjava.services;

import com.example.cs5610fall2020projectteam23serverjava.models.Movie;
import com.example.cs5610fall2020projectteam23serverjava.models.Review;
import com.example.cs5610fall2020projectteam23serverjava.models.ReviewId;
import com.example.cs5610fall2020projectteam23serverjava.models.User;
import com.example.cs5610fall2020projectteam23serverjava.repositories.MovieRepository;
import com.example.cs5610fall2020projectteam23serverjava.repositories.ReviewRepository;
import com.example.cs5610fall2020projectteam23serverjava.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserMovieReviewService {
    @Autowired
    ReviewRepository reviewRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    MovieRepository movieRepository;

    public Review createReview(
            Integer userId,
            Integer movieId,
            Review newReview) {
        Review review = new Review();
        review.setUserId(userId);
        review.setMovieId(movieId);
        review.setReviewContent(newReview.getReviewContent());
        review.setUser(userRepository.findById(userId).get());
        review.setMovie(movieRepository.findById(movieId).get());
        reviewRepository.save(review);
        return review;
    }

    public Review findReviewById (            Integer userId,
                                              Integer movieId) {
        ReviewId reviewId = new ReviewId();
        reviewId.setUserId(userId);
        reviewId.setMovieId(movieId);
        return reviewRepository.findById(reviewId).get();
    }

    public List<Review> findAllReview() {
        return (List<Review>) reviewRepository.findAll();
    }

    public Review updateReview(
            Integer userId,
            Integer movieId,
            Review newReview) {

        ReviewId reviewId = new ReviewId();
        reviewId.setUserId(userId);
        reviewId.setMovieId(movieId);

        Optional newReviewTemp = reviewRepository.findById(reviewId);
        if(newReviewTemp.isPresent()) {
            Review review = (Review) newReviewTemp.get();
            review.setReviewContent(newReview.getReviewContent());
            return reviewRepository.save(review);
        } else {
            return null;
        }
    }


    public void deleteReview(
            Integer userId,
            Integer movieId) {
        ReviewId reviewId = new ReviewId();
        reviewId.setUserId(userId);
        reviewId.setMovieId(movieId);
        reviewRepository.deleteById(reviewId);
    }
}
