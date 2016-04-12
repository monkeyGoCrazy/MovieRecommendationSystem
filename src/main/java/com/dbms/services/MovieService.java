package com.dbms.services;

/**
 * Created by mengleisun on 3/14/16.
 */
import com.dbms.domain.Movie;
import org.springframework.stereotype.Service;

public interface MovieService {
    Iterable<Movie> listAllMovies();
    Movie getMovieByTitle(String title);
    Iterable<Movie> getMovieByGenre(String genre);
    Iterable<Movie> getMovieByDirector(String director);
//    Movie saveMovie(Movie movie);
//    void deleteMovie(Integer mid);
}
