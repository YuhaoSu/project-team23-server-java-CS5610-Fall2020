package com.example.cs5610fall2020projectteam23serverjava.services;

//import com.example.cs5610fall2020projectteam23serverjava.models.Administrator;
import com.example.cs5610fall2020projectteam23serverjava.models.RegisteredUser;
import com.example.cs5610fall2020projectteam23serverjava.models.User;
import com.example.cs5610fall2020projectteam23serverjava.repositories.RegisteredUserRepository;
import com.example.cs5610fall2020projectteam23serverjava.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


    public RegisteredUser createRegisteredUser (RegisteredUser registeredUser) {
        return registeredUserRepository.save(registeredUser);
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
}
