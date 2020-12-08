package com.example.cs5610fall2020projectteam23serverjava.repositories;

import com.example.cs5610fall2020projectteam23serverjava.models.Movie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface MovieRepository
    extends CrudRepository<Movie, Integer> {

    @Query("select movie from Movie movie where movie.imdbID=:imdbId")
    public Movie findMovieByImdbId(
            @Param("imdbId") String imdbId);

    @Query(value="SELECT * FROM movies order by movie_id DESC limit 0, 10;", nativeQuery = true)
    public List<Movie> findRecentlyAddedMovie(
            );
}
