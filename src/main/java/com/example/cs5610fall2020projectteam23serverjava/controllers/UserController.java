package com.example.cs5610fall2020projectteam23serverjava.controllers;

//import com.example.cs5610fall2020projectteam23serverjava.models.Administrator;
import com.example.cs5610fall2020projectteam23serverjava.models.RegisteredUser;
import com.example.cs5610fall2020projectteam23serverjava.models.User;
import com.example.cs5610fall2020projectteam23serverjava.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
//@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
@CrossOrigin(origins = {"http://cs5610-client-react-team23.herokuapp.com", "http://localhost:3000"}, allowCredentials = "true")

public class UserController {
    @Autowired
    UserService service;


    @GetMapping("/api/users/{userId}")
    public User findUserById(
            @PathVariable("userId") Integer id) {
        return service.findUserById(id);
    }

    @GetMapping("/api/users")
    public List<User> findAllUser() {
        return service.findAllUsers();
    }

    @GetMapping("/api/users/recentUsers")
    public List<User> findRecentUsers() {
        return service.findRecentUsers();
    }


    @PostMapping("/api/users")
    public User createUser(HttpSession session,
                           @RequestBody User user) {
        return service.register(session, user);
    }

    @PutMapping("/api/users")
    public User updateUser(
            @RequestBody User newUser) {
        return service.updateUser(newUser);
    }

    @DeleteMapping("/api/users/{userId}")
    public void deleteUser(
            @PathVariable("userId") Integer userId) {
        service.deleteUser(userId);
    }

    @PostMapping("/api/users/profile")
    public User profile(HttpSession session) {
        User profile = (User)session.getAttribute("profile");
        return profile;
    }

    @PostMapping("/api/users/logout")
    public void logout(HttpSession session) {
        service.logout(session);
    }

    @PostMapping("/api/users/login")
    public User login(HttpSession session,
                      @RequestBody User user) {
        User profile = service.login(session, user);
        session.setAttribute("profile", profile);
        return profile;
    }


}
