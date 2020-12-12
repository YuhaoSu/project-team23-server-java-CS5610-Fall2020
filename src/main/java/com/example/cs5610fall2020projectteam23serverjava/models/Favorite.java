package com.example.cs5610fall2020projectteam23serverjava.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;


@Entity
@Table(name="favorites")
@IdClass(FavoriteId.class)
public class Favorite {
    @Id
    private Integer userId;
    @Id
    private Integer movieId;
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

    public Favorite() {
    }

    public Favorite(Integer userId, Integer movieId, User user, Movie movie) {
        this.userId = userId;
        this.movieId = movieId;
        this.user = user;
        this.movie = movie;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
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
