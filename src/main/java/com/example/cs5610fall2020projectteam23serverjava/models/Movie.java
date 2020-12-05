package com.example.cs5610fall2020projectteam23serverjava.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer movieId;
    private String imdbID;
    private String title;
    private String year;
    private String imdbVotes;
    @OneToMany(mappedBy = "movie")
    private List<Review> usersReview;
    @OneToMany(mappedBy = "movie")
    private List<Favorite> usersFavorite;

    public Movie () {
    }

    public Movie(Integer movieId, String imdbID, String title, String year, String imdbVotes, List<Review> usersReview, List<Favorite> usersFavorite) {
        this.movieId = movieId;
        this.imdbID = imdbID;
        this.title = title;
        this.year = year;
        this.imdbVotes = imdbVotes;
        this.usersReview = usersReview;
        this.usersFavorite = usersFavorite;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public String getImdbID() {
        return imdbID;
    }

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
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

    public String getImdbVotes() {
        return imdbVotes;
    }

    public void setImdbVotes(String imdbVotes) {
        this.imdbVotes = imdbVotes;
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
