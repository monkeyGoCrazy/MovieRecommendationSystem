package com.dbms.services;

/**
 * Created by mengleisun on 3/14/16.
 */
import com.dbms.domain.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

public interface MovieService {
    Movie getMovieByTitle(String title);
    Iterable<Movie> getMovieByGenre(String genre);
    Iterable<Movie> getMovieByDirector(String director);
    Page<Movie> findAll(Pageable pageable);
//    Movie saveMovie(Movie movie);
//    void deleteMovie(Integer mid);
}
