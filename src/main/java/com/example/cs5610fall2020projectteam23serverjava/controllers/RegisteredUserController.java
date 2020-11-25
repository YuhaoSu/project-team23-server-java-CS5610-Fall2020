package com.example.cs5610fall2020projectteam23serverjava.controllers;

//import com.example.cs5610fall2020projectteam23serverjava.models.Administrator;
import com.example.cs5610fall2020projectteam23serverjava.models.RegisteredUser;
import com.example.cs5610fall2020projectteam23serverjava.models.User;
import com.example.cs5610fall2020projectteam23serverjava.services.RegisteredUserService;
import com.example.cs5610fall2020projectteam23serverjava.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
//@CrossOrigin(origins = "*")

public class RegisteredUserController {
    @Autowired
    RegisteredUserService service;

    @GetMapping("/api/registeredUser/{registeredUserId}")
    public RegisteredUser findRegisteredUserId(
            @PathVariable("registeredUserId") Integer id) {
        return service.findUserById(id);
    }

    @GetMapping("/api/registeredUsers")
    public List<RegisteredUser> findAllRegisteredUser() {
        return service.findAllUsers();
    }

    @PostMapping("/api/registeredUsers")
    public RegisteredUser createRegisteredUser(
            @RequestBody RegisteredUser registeredUser) {
        return service.createRegisteredUser(registeredUser);
    }

    @PutMapping("/api/registeredUsers")
    public RegisteredUser updateRegisteredUser(
            @RequestBody RegisteredUser newRegisteredUser) {
        return service.updateRegisteredUser(newRegisteredUser);
    }

    @DeleteMapping("/api/registeredUser/{registeredUserId}")
    public void deleteRegisteredUser(
            @PathVariable("registeredUserId") Integer registeredUserId) {
        service.deleteRegisteredUser(registeredUserId);
    }

    @PostMapping("/api/registeredUsers/")
    public User register(HttpSession session,
                         @RequestBody RegisteredUser newRegisteredUser) {
        User newUser = service.createRegisteredUser(newRegisteredUser);
        session.setAttribute("currentRegisteredUser", newUser);
        return newUser;
    }

//    @PostMapping("/api/profile")
//    public User profile(HttpSession session) {
//        User profile = (User)session.getAttribute("profile");
//        return profile;
//    }

    @PostMapping("/api/logoutRegisteredUser/")
    public void logout(HttpSession session) {
        session.invalidate();
    }

//    http://localhost:8080/api/loginRegisteredUser
    @PostMapping("/api/loginRegisteredUser/")
    public User login(HttpSession session,
                      @RequestBody User user) {
        User currentRegisteredUser = service.findRegisteredUserByCredentials(user.getUsername(), user.getPassword());
        session.setAttribute("currentRegisteredUser", currentRegisteredUser);
        return currentRegisteredUser;
    }

}
