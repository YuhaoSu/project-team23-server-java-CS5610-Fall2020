package com.example.cs5610fall2020projectteam23serverjava.models;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name="registerUsers")
public class RegisteredUser extends User{
    private Date dob;
    private String phone;

    public RegisteredUser() {
    }

    public RegisteredUser(Date dob, String phone) {
        this.dob = dob;
        this.phone = phone;
    }

    public RegisteredUser(Integer id, String username, String password, String email, List<Review> reviews, Date dob, String phone) {
        super(id, username, password, email, reviews);
        this.dob = dob;
        this.phone = phone;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date DOB) {
        this.dob = DOB;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
