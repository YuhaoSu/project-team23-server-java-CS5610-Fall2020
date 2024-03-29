package com.example.cs5610fall2020projectteam23serverjava.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="registerUsers")
public class RegisteredUser extends User{
    private String phone;

    public RegisteredUser() {
    }

    public RegisteredUser(String phone) {
        this.phone = phone;
    }

    public RegisteredUser(Integer userId, String username, String password, String email,String userStatus, List<Review> moviesReview, List<Favorite> moviesFavorite, String phone) {
        super(userId, username, password, email, userStatus, moviesReview, moviesFavorite);
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
