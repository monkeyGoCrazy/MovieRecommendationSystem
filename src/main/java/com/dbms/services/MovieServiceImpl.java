package com.dbms.services;

import com.dbms.repositories.MovieRepository;
import com.dbms.domain.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public Page<Movie> findAll(Pageable pageable) {
        return movieRepository.findAll(pageable);
    }
    @Override
    public Movie getMovieByTitle(String title) {
        return movieRepository.getMovieByTitle(title);
    }
}
