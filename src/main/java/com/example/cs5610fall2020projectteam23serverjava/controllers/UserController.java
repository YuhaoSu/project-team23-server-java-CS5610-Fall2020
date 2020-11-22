package com.example.cs5610fall2020projectteam23serverjava.controllers;

//import com.example.cs5610fall2020projectteam23serverjava.models.Administrator;
import com.example.cs5610fall2020projectteam23serverjava.models.User;
import com.example.cs5610fall2020projectteam23serverjava.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
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



    @PostMapping("/api/users")
    public User createUser(
            @RequestBody User user) {
        return service.createUser(user);
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

}
