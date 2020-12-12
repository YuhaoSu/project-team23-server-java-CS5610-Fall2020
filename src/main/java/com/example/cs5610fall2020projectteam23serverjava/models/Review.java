package com.example.cs5610fall2020projectteam23serverjava.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name="reviews")
@IdClass(ReviewId.class)
public class Review {
    @Id
    private Integer userId;
    @Id
    private Integer movieId;
    private String reviewContent;
    @ManyToOne
    @PrimaryKeyJoinColumn
            (name="userId",
                    referencedColumnName="userId")
    @JsonIgnore
    private User user;
    @ManyToOne
    @PrimaryKeyJoinColumn
            (name="movieId",
                    referencedColumnName="movieId")
    @JsonIgnore
    private Movie movie;

    public Review() {
    }

    public Review(Integer movieId, Integer userId, String reviewContent, User user, Movie movie) {
        this.movieId = movieId;
        this.userId = userId;
        this.reviewContent = reviewContent;
        this.user = user;
        this.movie = movie;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getReviewContent() {
        return reviewContent;
    }

    public void setReviewContent(String reviewContent) {
        this.reviewContent = reviewContent;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}
