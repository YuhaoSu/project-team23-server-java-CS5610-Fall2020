package com.example.cs5610fall2020projectteam23serverjava.repositories;

import com.example.cs5610fall2020projectteam23serverjava.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface UserRepository
    extends CrudRepository<User, Integer> {

    @Query("select user from User user where userId=:userId")
    public User findUserById(
            @Param("userId") Integer userId);
}
