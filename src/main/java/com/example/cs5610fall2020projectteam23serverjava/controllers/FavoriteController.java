package com.example.cs5610fall2020projectteam23serverjava.controllers;

import com.example.cs5610fall2020projectteam23serverjava.models.Favorite;
import com.example.cs5610fall2020projectteam23serverjava.services.UserMovieFavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class FavoriteController {
    @Autowired
    UserMovieFavoriteService service;

    @GetMapping("/api/favorites/{userId}/for/{movieId}")
    public Favorite findFavoriteById(
            @PathVariable("userId") Integer userId,
            @PathVariable("movieId") Integer movieId) {
        return service.findFavoriteById(userId, movieId);
    }

    @GetMapping("/api/favorites")
    public List<Favorite> findAllFavorite() {
        return service.findAllFavorite();
    }

   @PostMapping("/api/favorites/{userId}/for/{movieId}")
    public Favorite createFavorite(
            @PathVariable("userId") Integer userId,
            @PathVariable("movieId") Integer movieId,
            @RequestBody Favorite newFavorite) {
        return service.createFavorite(userId, movieId, newFavorite);
    }

    @PutMapping("/api/favorites/{userId}/for/{movieId}")
    public Favorite updateFavorites(
            @PathVariable("userId") Integer userId,
            @PathVariable("movieId") Integer movieId,
            @RequestBody Favorite newFavorite) {
        return service.updateFavorite(userId, movieId, newFavorite);
    }

    @DeleteMapping("/api/favorites/{userId}/for/{movieId}")
    public void deleteFavorite(
            @PathVariable("userId") Integer userId,
            @PathVariable("movieId") Integer movieId) {
        service.deleteFavorite(userId, movieId);
    }
}
