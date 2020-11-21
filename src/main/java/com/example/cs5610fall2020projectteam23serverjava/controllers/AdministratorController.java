package com.example.cs5610fall2020projectteam23serverjava.controllers;

import com.example.cs5610fall2020projectteam23serverjava.models.Administrator;
import com.example.cs5610fall2020projectteam23serverjava.models.RegisteredUser;
import com.example.cs5610fall2020projectteam23serverjava.services.AdministratorService;
import com.example.cs5610fall2020projectteam23serverjava.services.RegisteredUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class AdministratorController {
    @Autowired
    AdministratorService service;

    @GetMapping("/api/administrator/{administratorId}")
    public Administrator findUserById(
            @PathVariable("administratorId") Integer id) {
        return service.findAdministratorById(id);
    }


    @GetMapping("/api/administrators")
    public List<Administrator> findAllAdministratorId() {
        return service.findAllAdministrator();
    }


/*    @GetMapping("/api/topics/{topicId}/widgets")
    public List<User> findWidgetsForTopic(
            @PathVariable("topicId") String topicId) {
        return service.findWidgetsForTopic(topicId);
    }

    @GetMapping("/api/widgets")
    public List<User> findAllWidgets() {
        return service.findAllWidgets();
    }

    @GetMapping("/api/widgets/{wid}")
    public User findWidgetById(
            @PathVariable("wid") Integer widgetId) {
        return service.findWidgetById(widgetId);
    }
    @PostMapping("/api/topics/{tid}/widgets")
    public User createWidget(
            @PathVariable("tid") String topicId,
            @RequestBody User user) {
        user.setTopicId(topicId);
        return service.createWidget(topicId, user);
    }
    @PutMapping("/api/widgets/{wid}")
    public User updateWidget(
            @PathVariable("wid") Integer widgetId,
            @RequestBody User newUser) {
        return service.updateWidget(widgetId, newUser);
    }

    @PutMapping("/api/topics/{topicId}/widgets")
    public List<User> saveAllWidget(
            @PathVariable("topicId") String topicId,
            @RequestBody List<User> newUserList) {
        return service.saveAllWidget(topicId, newUserList);
    }

    @DeleteMapping("/api/widgets/{wid}")
    public void deleteWidget(
            @PathVariable("wid") Integer widgetId) {
        service.deleteWidget(widgetId);
    }*/
}
