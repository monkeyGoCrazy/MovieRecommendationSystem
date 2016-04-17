package com.dbms.services;

import com.dbms.repositories.MovieRepository;
import com.dbms.domain.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

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
    public List<Movie> findByDirector(String director) {
        return movieRepository.findByDirector(director);
    }
    @Override
    public List<Movie> findByCompany(String company) {
        return movieRepository.findByCompany(company);
    }
    @Override
    public List<Movie> findByGenre(String genre, Pageable pageRequest) {
        return movieRepository.findByGenre(genre,pageRequest);
    }
    @Override
    public List<Movie> findByYear(int year, Pageable pageRequest) {
        return movieRepository.findByYear(year,pageRequest);
    }
    @Override
    public List<Movie> findByLength(int length,Pageable pageRequest) {
        return movieRepository.findByLength(length,pageRequest);
    }
    @Override
    public List<Movie> findByFuzzyTitle(String title) {
        return movieRepository.findByFuzzyTitle(title);
    }
    @Override
    public List<Movie> findByActor(String actor, Pageable pageRequest) {
        return movieRepository.findByActor(actor,pageRequest);
    }
    @Override
    public List<Movie> findByActorAndYear(String actor,int year,Pageable pageRequest) {
        return movieRepository.findByActorAndYear(actor,year,pageRequest);
    }
    @Override
    public List<Movie> findByActress(String actress,Pageable pageRequest) {
        return movieRepository.findByActress(actress,pageRequest);
    }
    @Override
    public List<Movie> findByActressAndActor(String actress, String actor,Pageable pageRequest) {
        return movieRepository.findByActressAndActor(actress,actor,pageRequest);
    }
    @Override
    public List<Movie> findByActorAndGenre(String actor,String genre,Pageable pageRequest) {
        return movieRepository.findByActorAndGenre(actor,genre,pageRequest);
    }
    @Override
    public List<Movie> findByTopRating(float rating, Pageable pageRequest) {
        return movieRepository.findByTopRating(rating,pageRequest);
    }
    @Override
    public List<Movie> findByTopVotes(int votes,Pageable pageRequest) {
        return movieRepository.findByTopVotes(votes,pageRequest);
    }
    @Override
    public Page<Movie> findAll(Pageable pageable) {
        return movieRepository.findAll(pageable);
    }
    @Override
    public Movie findByTitle(String title) {
        return movieRepository.findMovieByTitle(title);
    }
}
