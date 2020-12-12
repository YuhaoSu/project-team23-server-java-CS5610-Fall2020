package com.example.cs5610fall2020projectteam23serverjava.controllers;


import com.example.cs5610fall2020projectteam23serverjava.models.RegisteredUser;
import com.example.cs5610fall2020projectteam23serverjava.services.RegisteredUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
//@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
//@CrossOrigin(origins = "http://cs5610-client-react-team23.herokuapp.com", allowCredentials = "true")
@CrossOrigin(origins = {"http://cs5610-client-react-team23.herokuapp.com", "http://localhost:3000"}, allowCredentials = "true")

public class RegisteredUserController {
    @Autowired
    RegisteredUserService service;

    @GetMapping("/api/registeredUsers/{registeredUserId}")
    public RegisteredUser findRegisteredUserById(
            @PathVariable("registeredUserId") Integer id) {
        return service.findUserById(id);
    }


    @GetMapping("/api/registeredUsers")
    public List<RegisteredUser> findAllRegisteredUser() {
        return service.findAllUsers();
    }



    @PutMapping("/api/registeredUsers")
    public RegisteredUser updateRegisteredUser(
            @RequestBody RegisteredUser newRegisteredUser) {
        return service.updateRegisteredUser(newRegisteredUser);
    }

    @DeleteMapping("/api/registeredUsers/{registeredUserId}")
    public void deleteRegisteredUser(
            @PathVariable("registeredUserId") Integer registeredUserId) {
        service.deleteRegisteredUser(registeredUserId);
    }

    @PostMapping("/api/registeredUsers")
    public RegisteredUser createRegisteredUser(
            HttpSession session,
            @RequestBody RegisteredUser registeredUser) {
        return service.createRegisteredUser(session, registeredUser);
    }

    @PostMapping("/api/registeredUsers/profile")
    public RegisteredUser profile(HttpSession session) {
        RegisteredUser profile = (RegisteredUser)session.getAttribute("profile");
        return profile;
    }

    @PostMapping("/api/registeredUsers/logout")
    public void logout(HttpSession session) {
        service.logout(session);
    }

    @PostMapping("/api/registeredUsers/login")
    public RegisteredUser login(HttpSession session,
                      @RequestBody RegisteredUser user) {
        return service.login(session, user);
    }

}
