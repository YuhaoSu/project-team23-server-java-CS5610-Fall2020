package com.example.cs5610fall2020projectteam23serverjava.repositories;

import com.example.cs5610fall2020projectteam23serverjava.models.Administrator;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface AdministratorRepository
    extends CrudRepository<Administrator, Integer> {

    @Query("SELECT user FROM User user WHERE user.username=:username AND user.password=:password")
    public Administrator findAdministratorByCredentials(
            @Param("username") String username,
            @Param("password") String password
    );


}
