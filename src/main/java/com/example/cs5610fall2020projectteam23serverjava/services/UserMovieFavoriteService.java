package com.example.cs5610fall2020projectteam23serverjava.services;

import com.example.cs5610fall2020projectteam23serverjava.models.Favorite;
import com.example.cs5610fall2020projectteam23serverjava.models.FavoriteId;
import com.example.cs5610fall2020projectteam23serverjava.repositories.FavoriteRepository;
import com.example.cs5610fall2020projectteam23serverjava.repositories.MovieRepository;
import com.example.cs5610fall2020projectteam23serverjava.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserMovieFavoriteService {
    @Autowired
    FavoriteRepository favoriteRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    MovieRepository movieRepository;

    public Favorite createFavorite(
            Integer userId,
            Integer movieId,
            Favorite newFavorite) {
        Favorite favorite = new Favorite();
        favorite.setUserId(userId);
        favorite.setMovieId(movieId);
        favorite.setUser(userRepository.findById(userId).get());
        favorite.setMovie(movieRepository.findById(movieId).get());
        favoriteRepository.save(favorite);
        return favorite;
    }

    public Favorite findFavoriteById (            Integer userId,
                                              Integer movieId) {
        FavoriteId favoriteId = new FavoriteId();
        favoriteId.setUserId(userId);
        favoriteId.setMovieId(movieId);
        return favoriteRepository.findById(favoriteId).get();
    }

    public List<Favorite> findAllFavorite() {
        return (List<Favorite>) favoriteRepository.findAll();
    }

    public Favorite updateFavorite(
            Integer userId,
            Integer movieId,
            Favorite newFavorite) {

        FavoriteId favoriteId = new FavoriteId();
        favoriteId.setUserId(userId);
        favoriteId.setMovieId(movieId);

        Optional newFavoriteTemp = favoriteRepository.findById(favoriteId);
        if(newFavoriteTemp.isPresent()) {
            Favorite favorite = (Favorite) newFavoriteTemp.get();
            return favoriteRepository.save(favorite);
        } else {
            return null;
        }
    }


    public void deleteFavorite(
            Integer userId,
            Integer movieId) {
        FavoriteId favoriteId = new FavoriteId();
        favoriteId.setUserId(userId);
        favoriteId.setMovieId(movieId);
        favoriteRepository.deleteById(favoriteId);
    }
}
