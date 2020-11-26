package com.example.cs5610fall2020projectteam23serverjava.repositories;


import com.example.cs5610fall2020projectteam23serverjava.models.Favorite;
import com.example.cs5610fall2020projectteam23serverjava.models.FavoriteId;
import org.springframework.data.repository.CrudRepository;

public interface FavoriteRepository
    extends CrudRepository<Favorite, FavoriteId> {




}
