package com.example.cs5610fall2020projectteam23serverjava.controllers;

import com.example.cs5610fall2020projectteam23serverjava.models.Administrator;
import com.example.cs5610fall2020projectteam23serverjava.models.RegisteredUser;
import com.example.cs5610fall2020projectteam23serverjava.models.User;
import com.example.cs5610fall2020projectteam23serverjava.services.AdministratorService;
import com.example.cs5610fall2020projectteam23serverjava.services.RegisteredUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
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

    @PostMapping("/api/administrators")
    public Administrator createAdministrator(
            @RequestBody Administrator administrator) {
        return service.createAdministrator(administrator);
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


}
