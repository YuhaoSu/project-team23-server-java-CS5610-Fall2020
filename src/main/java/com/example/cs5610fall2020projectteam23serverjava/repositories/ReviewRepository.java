package com.example.cs5610fall2020projectteam23serverjava.repositories;


import com.example.cs5610fall2020projectteam23serverjava.models.Review;
import com.example.cs5610fall2020projectteam23serverjava.models.ReviewId;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReviewRepository
    extends CrudRepository<Review, ReviewId> {


    @Query("SELECT review FROM Review review WHERE review.movieId=:movieId")
    public List<Review> findReviewsByMovieID(
            @Param("movieId") Integer movieId
    );


}
