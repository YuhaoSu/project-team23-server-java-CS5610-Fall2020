package com.example.cs5610fall2020projectteam23serverjava.controllers;

import com.example.cs5610fall2020projectteam23serverjava.models.Administrator;
import com.example.cs5610fall2020projectteam23serverjava.models.RegisteredUser;
import com.example.cs5610fall2020projectteam23serverjava.models.User;
import com.example.cs5610fall2020projectteam23serverjava.services.AdministratorService;
import com.example.cs5610fall2020projectteam23serverjava.services.RegisteredUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
//@CrossOrigin(origins = "https://cs5610-server-java-team23.herokuapp.com/", allowCredentials = "true")

public class AdministratorController {
    @Autowired
    AdministratorService service;

    @GetMapping("/api/administrator/{administratorId}")
    public Administrator findAdministratorById(
            @PathVariable("administratorId") Integer id) {
        return service.findAdministratorById(id);
    }


    @GetMapping("/api/administrators")
    public List<Administrator> findAllAdministrator() {
        return service.findAllAdministrator();
    }


    @PutMapping("/api/administrators")
    public Administrator updateAdministrator(
            @RequestBody Administrator newAdministrator) {
        return service.updateAdministrator(newAdministrator);
    }

    @DeleteMapping("/api/administrator/{administratorId}")
    public void deleteAdministrator(
            @PathVariable("administratorId") Integer administratorId) {
        service.deleteAdministrator(administratorId);
    }

    @PostMapping("/api/administrators")
    public Administrator createAdministrator(
            HttpSession session,
            @RequestBody Administrator administrator) {
        return service.createAdministrator(session, administrator);
    }

    @PostMapping("/api/administrator/profile")
    public Administrator profile(HttpSession session) {
        Administrator profile = (Administrator)session.getAttribute("profile");
        return profile;
    }

    @PostMapping("/api/administrator/logout")
    public void logout(HttpSession session) {
        service.logout(session);
    }

    @PostMapping("/api/administrator/login")
    public Administrator login(HttpSession session,
                                @RequestBody Administrator user) {
        return service.login(session, user);
    }


}
