package com.example.cs5610fall2020projectteam23serverjava.controllers;

import com.example.cs5610fall2020projectteam23serverjava.models.Administrator;
import com.example.cs5610fall2020projectteam23serverjava.services.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
//@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
//@CrossOrigin(origins = "http://cs5610-client-react-team23.herokuapp.com", allowCredentials = "true")
@CrossOrigin(origins = {"http://cs5610-client-react-team23.herokuapp.com", "http://localhost:3000"}, allowCredentials = "true")

public class AdministratorController {
    @Autowired
    AdministratorService service;

    @GetMapping("/api/administrators/{administratorId}")
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

    @DeleteMapping("/api/administrators/{administratorId}")
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

    @PostMapping("/api/administrators/profile")
    public Administrator profile(HttpSession session) {
        Administrator profile = (Administrator)session.getAttribute("profile");
        return profile;
    }

    @PostMapping("/api/administrators/logout")
    public void logout(HttpSession session) {
        service.logout(session);
    }

    @PostMapping("/api/administrators/login")
    public Administrator login(HttpSession session,
                                @RequestBody Administrator user) {
        return service.login(session, user);
    }


}
