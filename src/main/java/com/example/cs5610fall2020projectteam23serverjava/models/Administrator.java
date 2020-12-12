package com.example.cs5610fall2020projectteam23serverjava.models;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name="administrators")
public class Administrator extends User{
    private String adminId;

    public Administrator() {
    }

    public Administrator(String adminId) {
        this.adminId = adminId;
    }

    public Administrator(Integer userId, String username, String password, String email, String userStatus, List<Review> moviesReview, List<Favorite> moviesFavorite, String adminId) {
        super(userId, username, password, email, userStatus, moviesReview, moviesFavorite);
        this.adminId = adminId;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }
}
