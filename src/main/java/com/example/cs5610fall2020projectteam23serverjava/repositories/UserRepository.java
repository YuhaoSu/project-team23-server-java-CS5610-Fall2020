package com.example.cs5610fall2020projectteam23serverjava.repositories;

import com.example.cs5610fall2020projectteam23serverjava.models.Movie;
import com.example.cs5610fall2020projectteam23serverjava.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface UserRepository
    extends CrudRepository<User, Integer> {

    @Query("SELECT user FROM User user WHERE user.username=:username AND user.password=:password")
    public User findUserByCredentials(
            @Param("username") String username,
            @Param("password") String password
    );

    @Query("select user FROM User user order by user.userId DESC ")
    public List<User> findRecentUsers(
    );


}
