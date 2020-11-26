package com.example.cs5610fall2020projectteam23serverjava.models;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name="administrators")
public class Administrator extends User{
    private Boolean admin;

    public Administrator() {
    }

    public Administrator(Boolean admin) {
        this.admin = admin;
    }

    public Administrator(Integer userId, String username, String password, String email, List<Review> moviesReview, List<Favorite> moviesFavorite, Boolean admin) {
        super(userId, username, password, email, moviesReview, moviesFavorite);
        this.admin = admin;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }
}
