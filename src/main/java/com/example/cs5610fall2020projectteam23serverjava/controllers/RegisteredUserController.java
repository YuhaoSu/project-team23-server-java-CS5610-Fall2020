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
//@CrossOrigin(origins = "https://cs5610-server-java-team23.herokuapp.com/", allowCredentials = "true")
public class RegisteredUserController {
    @Autowired
    RegisteredUserService service;

    @GetMapping("/api/registeredUser/{registeredUserId}")
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

    @DeleteMapping("/api/registeredUser/{registeredUserId}")
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

    @PostMapping("/api/registeredUser/profile")
    public RegisteredUser profile(HttpSession session) {
        RegisteredUser profile = (RegisteredUser)session.getAttribute("profile");
        return profile;
    }

    @PostMapping("/api/registeredUser/logout")
    public void logout(HttpSession session) {
        service.logout(session);
    }

    @PostMapping("/api/registeredUser/login")
    public RegisteredUser login(HttpSession session,
                      @RequestBody RegisteredUser user) {
        return service.login(session, user);
    }



}
