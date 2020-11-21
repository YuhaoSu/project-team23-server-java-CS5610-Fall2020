package com.example.cs5610fall2020projectteam23serverjava.services;

import com.example.cs5610fall2020projectteam23serverjava.models.RegisteredUser;
import com.example.cs5610fall2020projectteam23serverjava.models.User;
import com.example.cs5610fall2020projectteam23serverjava.repositories.RegisteredUserRepository;
import com.example.cs5610fall2020projectteam23serverjava.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegisteredUserService {
    @Autowired
    RegisteredUserRepository registeredUserRepository;

    public RegisteredUser findUserById (Integer registeredUserId) {
        return registeredUserRepository.findById(registeredUserId).get();
    }

    public List<RegisteredUser> findAllUsers() {
        return (List<RegisteredUser>) registeredUserRepository.findAll();
    }


/*
    public List<User> findWidgetsForTopic(String tid) {
        return userRepository.findUserById(tid);
    }
    public List<User> findAllWidgets() {
        return (List<User>) userRepository.findAll();
    }
    public User findWidgetById(Integer widgetId) {
        return userRepository.findById(widgetId).get();
    }
    public User createWidget(String tid, User user) {
        user.setTopicId(tid);
        return userRepository.save(user);
    }
    public User updateWidget(
            Integer widgetId,
            User newUser) {

        Optional widgetO = userRepository.findById(widgetId);
        if(widgetO.isPresent()) {
            User user = (User) widgetO.get();
            user.setName(newUser.getName());
            user.setType(newUser.getType());
            user.setTopicId(newUser.getTopicId());
            user.setText(newUser.getText());
            user.setSize(newUser.getSize());
            user.setSrc(newUser.getSrc());
            user.setWidth(newUser.getWidth());
            user.setHeight(newUser.getHeight());
            user.setWidgetOrder(newUser.getWidgetOrder());
            user.setCssClass(newUser.getCssClass());
            user.setStyle(newUser.getStyle());
            user.setValue(newUser.getValue());
            user.setOrdered(newUser.getOrdered());
            return userRepository.save(user);
        } else {
            return null;
        }
    }

    public void deleteWidget(
            Integer widgetId) {
        userRepository.deleteById(widgetId);
    }


    public List<User> saveAllWidget(String topicId, List<User> widgetsNew) {
        List<User> oldUserListById =  userRepository.findUserById(topicId);

        for(User d: oldUserListById){
            userRepository.deleteById(d.getId());
        }

        for(User s: widgetsNew){
            userRepository.save(s);
        }
        return userRepository.findUserById(topicId);
    }*/
}
