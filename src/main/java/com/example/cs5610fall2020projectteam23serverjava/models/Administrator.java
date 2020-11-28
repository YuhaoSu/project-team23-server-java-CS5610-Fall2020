package com.example.cs5610fall2020projectteam23serverjava.models;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name="administrators")
public class Administrator extends User{
    private Integer adminId;

    public Administrator() {
    }

    public Administrator(Integer admin) {
        this.adminId = adminId;
    }

    public Administrator(Integer userId, String username, String password, String email, String userStatus, List<Review> moviesReview, List<Favorite> moviesFavorite, Integer adminId) {
        super(userId, username, password, email,userStatus, moviesReview, moviesFavorite);
        this.adminId = adminId;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }
}
