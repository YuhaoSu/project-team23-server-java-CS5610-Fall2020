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
    @OneToMany(mappedBy = "movie")
    private List<Review> users;

    public Movie () {
    }

    public Movie(Integer movieId, String imdbID, String title, String year, List<Review> users) {
        this.movieId = movieId;
        this.imdbID = imdbID;
        this.title = title;
        this.year = year;
        this.users = users;
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

    public List<Review> getReviews() {
        return users;
    }

    public void setReviews(List<Review> users) {
        this.users = users;
    }
}
