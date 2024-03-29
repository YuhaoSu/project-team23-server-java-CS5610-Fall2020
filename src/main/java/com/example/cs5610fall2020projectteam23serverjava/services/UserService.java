package com.example.cs5610fall2020projectteam23serverjava.services;

import com.example.cs5610fall2020projectteam23serverjava.models.User;
import com.example.cs5610fall2020projectteam23serverjava.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public List<User> findRecentUsers() {
        return (List<User>) userRepository.findRecentUsers();
    }

    public User updateUser(
            User newUser) {

        Optional newUserTemp = userRepository.findById(newUser.getUserId());
        if(newUserTemp.isPresent()) {
            User user = (User) newUserTemp.get();
            user.setEmail(newUser.getEmail());
            user.setPassword(newUser.getPassword());
            user.setUsername(newUser.getUsername());
            user.setUserStatus(newUser.getUserStatus());
            user.setMoviesReview(newUser.getMoviesReview());
            user.setMoviesFavorite(newUser.getMoviesFavorite());
            return userRepository.save(user);
        } else {
            return null;
        }
    }

    public void deleteUser(
            Integer userId) {
        userRepository.deleteById(userId);
    }

    public void logout(HttpSession session) {
        session.invalidate();
    }

    public User login(HttpSession session,
                      User user) {
        User profile = userRepository.findUserByCredentials(user.getUsername(), user.getPassword());
        return profile;
    }

    public User register(HttpSession session,
                         User user) {
        User newUser = userRepository.save(user);
        session.setAttribute("profile", newUser);
        return newUser;
    }
}
