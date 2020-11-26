package com.example.cs5610fall2020projectteam23serverjava.repositories;

import com.example.cs5610fall2020projectteam23serverjava.models.RegisteredUser;
import com.example.cs5610fall2020projectteam23serverjava.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface RegisteredUserRepository
    extends CrudRepository<RegisteredUser, Integer> {


    @Query("SELECT user FROM User user WHERE user.username=:username AND user.password=:password")
    public RegisteredUser findUserByCredentials(
            @Param("username") String username,
            @Param("password") String password
    );

}
