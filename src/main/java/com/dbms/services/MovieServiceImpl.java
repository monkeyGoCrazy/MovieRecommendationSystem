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
    public Iterable<Movie> findMovieByGenre(String genre) {
        return movieRepository.findMovieByGenre(genre);
    }
    @Override
    public Iterable<Movie> findMovieByDirector(String director) {
        return movieRepository.findMovieByDirector(director);
    }
    @Override
    public Page<Movie> findAll(Pageable pageable) {
        return movieRepository.findAll(pageable);
    }
    @Override
    public Movie findMovieByTitle(String title) {
        return movieRepository.findMovieByTitle(title);
    }
    @Override
    public Iterable<Movie> findMovieByRating(float rating) {
        return movieRepository.findByRatingGreaterThan(rating);
    }
}
