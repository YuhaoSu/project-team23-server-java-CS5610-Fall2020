package com.example.cs5610fall2020projectteam23serverjava.services;

//import com.example.cs5610fall2020projectteam23serverjava.models.Administrator;
import com.example.cs5610fall2020projectteam23serverjava.models.User;
import com.example.cs5610fall2020projectteam23serverjava.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User findUserById (Integer userId) {
        return userRepository.findById(userId).get();
    }

    public List<User> findAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    public User createUser (User user) {
        return userRepository.save(user);
    }

    public User updateUser(
//            Integer userId,
            User newUser) {

        Optional newUserTemp = userRepository.findById(newUser.getId());
//        Optional newUserTemp = userRepository.findById(userId);
        if(newUserTemp.isPresent()) {
            User user = (User) newUserTemp.get();
            user.setEmail(newUser.getEmail());
            user.setPassword(newUser.getPassword());
            user.setUsername(newUser.getUsername());
            return userRepository.save(user);
        } else {
            return null;
        }
    }

    public void deleteUser(
            Integer userId) {
        userRepository.deleteById(userId);
    }



}
