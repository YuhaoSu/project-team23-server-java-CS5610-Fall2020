package com.example.cs5610fall2020projectteam23serverjava.services;

import com.example.cs5610fall2020projectteam23serverjava.models.Administrator;
import com.example.cs5610fall2020projectteam23serverjava.models.RegisteredUser;
import com.example.cs5610fall2020projectteam23serverjava.models.User;
import com.example.cs5610fall2020projectteam23serverjava.repositories.AdministratorRepository;
import com.example.cs5610fall2020projectteam23serverjava.repositories.RegisteredUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdministratorService {
    @Autowired
    AdministratorRepository administratorRepository;

    public Administrator findAdministratorById (Integer administratorId) {
        return administratorRepository.findById(administratorId).get();
    }

    public List<Administrator> findAllAdministrator() {
        return (List<Administrator>) administratorRepository.findAll();
    }

    public Administrator createAdministrator (Administrator administrators) {
        return administratorRepository.save(administrators);
    }

    public Administrator updateAdministrator(
            Administrator newAdministrator) {

        Optional newAdministratorTemp = administratorRepository.findById(newAdministrator.getId());
        if(newAdministratorTemp.isPresent()) {
            Administrator administrator = (Administrator) newAdministratorTemp.get();
            administrator.setEmail(newAdministrator.getEmail());
            administrator.setPassword(newAdministrator.getPassword());
            administrator.setUsername(newAdministrator.getUsername());
            administrator.setAdmin(newAdministrator.getAdmin());
            return administratorRepository.save(administrator);
        } else {
            return null;
        }
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
