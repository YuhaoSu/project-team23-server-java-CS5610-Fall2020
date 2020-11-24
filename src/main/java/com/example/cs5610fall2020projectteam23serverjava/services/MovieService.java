package com.example.cs5610fall2020projectteam23serverjava.services;

import com.example.cs5610fall2020projectteam23serverjava.models.Movie;
import com.example.cs5610fall2020projectteam23serverjava.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;

    public Movie findMovieById (Integer movieId) {
        return movieRepository.findById(movieId).get();
    }

    public List<Movie> findAllMovie() {
        return (List<Movie>) movieRepository.findAll();
    }

    public Movie createMovie (Movie movie) {
        return movieRepository.save(movie);
    }

    public Movie updateMovie(
            Movie newMovie) {

        Optional newMovieTemp = movieRepository.findById(newMovie.getMovieId());
        if(newMovieTemp.isPresent()) {
            Movie movie = (Movie) newMovieTemp.get();
            movie.setImdbID(newMovie.getTitle());
            movie.setTitle(newMovie.getTitle());
            movie.setYear(newMovie.getYear());

            return movieRepository.save(movie);

        } else {
            return null;
        }
    }

    public void deleteMovie(
            Integer movieId) {
        movieRepository.deleteById(movieId);
    }
}
