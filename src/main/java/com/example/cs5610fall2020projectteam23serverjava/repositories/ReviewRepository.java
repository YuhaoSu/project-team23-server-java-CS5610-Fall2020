package com.example.cs5610fall2020projectteam23serverjava.repositories;


import com.example.cs5610fall2020projectteam23serverjava.models.Review;
import com.example.cs5610fall2020projectteam23serverjava.models.ReviewId;
import org.springframework.data.repository.CrudRepository;

public interface ReviewRepository
    extends CrudRepository<Review, ReviewId> {




}
