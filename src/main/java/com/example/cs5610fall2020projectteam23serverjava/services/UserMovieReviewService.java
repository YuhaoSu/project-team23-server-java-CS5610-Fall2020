package com.example.cs5610fall2020projectteam23serverjava.services;

import com.example.cs5610fall2020projectteam23serverjava.models.Movie;
import com.example.cs5610fall2020projectteam23serverjava.models.Review;
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

    public User addReviewToUserMovie(
            Integer reviewId,
            Integer userId,
            Integer movieId) {
        User user   = userRepository.findById(userId).get();
        Movie movie   = movieRepository.findById(movieId).get();
        Review review = reviewRepository.findById(reviewId).get();
        user.getReviews().add(review);
        movie.getReviews().add(review);
        review.setUser(user);
        review.setMovie(movie);
        reviewRepository.save(review);
        return user;
    }

    public Review findReviewById (Integer reviewId) {
        return reviewRepository.findById(reviewId).get();
    }

    public List<Review> findAllReview() {
        return (List<Review>) reviewRepository.findAll();
    }

    public Review createReview (Integer userId, Review review, Integer movieId) {
        Review reviewTemp = reviewRepository.save(review);
        this.addReviewToUserMovie(reviewTemp.getReviewId(), userId, movieId );

        return findReviewById(reviewTemp.getReviewId());
    }

    public Review updateReview(
            Review newReview) {

        Optional newReviewTemp = reviewRepository.findById(newReview.getReviewId());
        if(newReviewTemp.isPresent()) {
            Review review = (Review) newReviewTemp.get();
            review.setReviewContent(newReview.getReviewContent());
            review.setUser(newReview.getUser());
            review.setMovie(newReview.getMovie());
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
