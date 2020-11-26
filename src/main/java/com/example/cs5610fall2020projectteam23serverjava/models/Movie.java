package com.example.cs5610fall2020projectteam23serverjava.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer movieId;
    private String imdbId;
    private String title;
    private String year;
    @OneToMany(mappedBy = "movie")
    private List<Review> usersReview;
    @OneToMany(mappedBy = "movie")
    private List<Favorite> usersFavorite;

    public Movie () {
    }

    public Movie(Integer movieId, String imdbId, String title, String year, List<Review> usersReview, List<Favorite> usersFavorite) {
        this.movieId = movieId;
        this.imdbId = imdbId;
        this.title = title;
        this.year = year;
        this.usersReview = usersReview;
        this.usersFavorite = usersFavorite;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public List<Review> getUsersReview() {
        return usersReview;
    }

    public void setUsersReview(List<Review> usersReview) {
        this.usersReview = usersReview;
    }

    public List<Favorite> getUsersFavorite() {
        return usersFavorite;
    }

    public void setUsersFavorite(List<Favorite> usersFavorite) {
        this.usersFavorite = usersFavorite;
    }
}