package com.example.cs5610fall2020projectteam23serverjava.controllers;

import com.example.cs5610fall2020projectteam23serverjava.models.Movie;
import com.example.cs5610fall2020projectteam23serverjava.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins = "*")
@CrossOrigin(origins = "http://cs5610-client-react-team23.herokuapp.com", allowCredentials = "true")
public class MovieController {
    @Autowired
    MovieService service;

    @GetMapping("/api/movies/{movieId}")
    public Movie findMovieById(
            @PathVariable("movieId") Integer id) {
        return service.findMovieById(id);
    }

    @GetMapping("/api/movies/imdb/{imdbId}")
    public Movie findMovieByImdbId(
            @PathVariable("imdbId") String imdbId) {
        return service.findMovieByImdbId(imdbId);
    }

    @GetMapping("/api/movies")
    public List<Movie> findAllMovie() {
        return service.findAllMovie();
    }

    @PostMapping("/api/movies")
    public Movie createMovie(
            @RequestBody Movie movie) {
        return service.createMovie(movie);
    }

    @PutMapping("/api/movies")
    public Movie updateMovies(
            @RequestBody Movie newMovie) {
        return service.updateMovie(newMovie);
    }

    @DeleteMapping("/api/movies/{movieId}")
    public void deleteMovie(
            @PathVariable("movieId") Integer movieId) {
        service.deleteMovie(movieId);
    }

    @GetMapping("/api/movies/moviesRecentlyAdded")
    public List<Movie> findRecentlyAddedMovie() {
        return service.findRecentlyAddedMovie();
    }

}
