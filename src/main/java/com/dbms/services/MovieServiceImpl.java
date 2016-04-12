package com.dbms.services;

import com.dbms.repositories.MovieRepository;
import com.dbms.domain.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by mengleisun on 3/15/16.
 */
@Service
public class MovieServiceImpl implements MovieService{
    private MovieRepository movieRepository;

    @Autowired
    public void setMovieRepository(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }
    @Override
    public Iterable<Movie> getMovieByGenre(String genre) {
        return movieRepository.getMovieByGenre(genre);
    }
    @Override
    public Iterable<Movie> getMovieByDirector(String director) {
        return movieRepository.getMovieByDirector(director);
    }
    @Override
    public Iterable<Movie> listAllMovies() {
        return movieRepository.findAll();
    }
    @Override
    public Movie getMovieByTitle(String title) {
        return movieRepository.getMovieByTitle(title);
    }
}
