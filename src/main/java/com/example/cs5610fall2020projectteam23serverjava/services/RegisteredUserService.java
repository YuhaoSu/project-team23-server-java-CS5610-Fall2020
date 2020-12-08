package com.example.cs5610fall2020projectteam23serverjava.services;

//import com.example.cs5610fall2020projectteam23serverjava.models.Administrator;
import com.example.cs5610fall2020projectteam23serverjava.models.RegisteredUser;
import com.example.cs5610fall2020projectteam23serverjava.models.User;
import com.example.cs5610fall2020projectteam23serverjava.repositories.RegisteredUserRepository;
import com.example.cs5610fall2020projectteam23serverjava.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

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



    public RegisteredUser updateRegisteredUser(
            RegisteredUser newRegisteredUser) {

        Optional newRegisteredUserTemp = registeredUserRepository.findById(newRegisteredUser.getUserId());
        if(newRegisteredUserTemp.isPresent()) {
            RegisteredUser registeredUser = (RegisteredUser) newRegisteredUserTemp.get();
            registeredUser.setEmail(newRegisteredUser.getEmail());
            registeredUser.setPassword(newRegisteredUser.getPassword());
            registeredUser.setUsername(newRegisteredUser.getUsername());
            registeredUser.setPhone(newRegisteredUser.getPhone());
            return registeredUserRepository.save(registeredUser);
        } else {
            return null;
        }
    }

    public void deleteRegisteredUser(
            Integer registeredUserId) {
        registeredUserRepository.deleteById(registeredUserId);
    }


    public void logout(HttpSession session) {
        session.invalidate();
    }

    public RegisteredUser login(HttpSession session,
                      @RequestBody User user) {
        RegisteredUser profile = registeredUserRepository.findUserByCredentials(user.getUsername(), user.getPassword());
        session.setAttribute("profile", profile);
        return profile;
    }

    public RegisteredUser createRegisteredUser(HttpSession session,
                         @RequestBody RegisteredUser registeredUser) {
        RegisteredUser newUser = registeredUserRepository.save(registeredUser);
        session.setAttribute("profile", newUser);
        return newUser;
    }

/*
    @PostMapping("/profile")
    public User profile(HttpSession session) {
        User profile = (User)session.getAttribute("profile");
        return profile;
    }

*/

}
