package com.example.cs5610fall2020projectteam23serverjava.controllers;

import com.example.cs5610fall2020projectteam23serverjava.models.RegisteredUser;
import com.example.cs5610fall2020projectteam23serverjava.models.User;
import com.example.cs5610fall2020projectteam23serverjava.services.RegisteredUserService;
import com.example.cs5610fall2020projectteam23serverjava.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class RegisteredUserController {
    @Autowired
    RegisteredUserService service;

    @GetMapping("/api/registeredUser/{registeredUserId}")
    public RegisteredUser findUserById(
            @PathVariable("registeredUserId") Integer id) {
        return service.findUserById(id);
    }


    @GetMapping("/api/registeredUsers")
    public List<RegisteredUser> findAllRegisteredUser() {
        return service.findAllUsers();
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
