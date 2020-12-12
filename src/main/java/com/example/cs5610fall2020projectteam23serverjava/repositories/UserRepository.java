package com.example.cs5610fall2020projectteam23serverjava.repositories;

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

    @Query(value="SELECT * FROM users order by user_id desc limit 0,10", nativeQuery = true)
    public List<User> findRecentUsers(
    );


}
