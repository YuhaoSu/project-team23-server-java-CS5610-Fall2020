package com.example.cs5610fall2020projectteam23serverjava.controllers;

//import com.example.cs5610fall2020projectteam23serverjava.models.Administrator;
import com.example.cs5610fall2020projectteam23serverjava.models.RegisteredUser;
import com.example.cs5610fall2020projectteam23serverjava.models.User;
import com.example.cs5610fall2020projectteam23serverjava.services.RegisteredUserService;
import com.example.cs5610fall2020projectteam23serverjava.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
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

}
