package com.example.cs5610fall2020projectteam23serverjava.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    private String username;
    private String password;
    private String email;
    private String userStatus;
    @OneToMany(mappedBy = "user")
    private List<Review> moviesReview;
    @OneToMany(mappedBy = "user")
    private List<Favorite> moviesFavorite;

    public User() {
    }

    public User(Integer userId, String username, String password, String email, String userStatus, List<Review> moviesReview, List<Favorite> moviesFavorite) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.email = email;
        this.userStatus = userStatus;
        this.moviesReview = moviesReview;
        this.moviesFavorite = moviesFavorite;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Review> getMoviesReview() {
        return moviesReview;
    }

    public void setMoviesReview(List<Review> moviesReview) {
        this.moviesReview = moviesReview;
    }

    public List<Favorite> getMoviesFavorite() {
        return moviesFavorite;
    }

    public void setMoviesFavorite(List<Favorite> moviesFavorite) {
        this.moviesFavorite = moviesFavorite;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }
}
