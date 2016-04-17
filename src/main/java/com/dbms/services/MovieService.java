package com.dbms.services;

/**
 * Created by mengleisun on 3/14/16.
 */
import com.dbms.domain.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

public interface MovieService {
    Movie findByTitle(String title);
    List<Movie> findByDirector(String director);
    List<Movie> findByCompany(String company);
    List<Movie> findByGenre(String genre, Pageable pageRequest);
    List<Movie> findByYear(int year, Pageable pageRequest);
    List<Movie> findByLength(int length,Pageable pageRequest);
    List<Movie> findByFuzzyTitle(String title);
    List<Movie> findByActor(String actor, Pageable pageRequest);
    List<Movie> findByActorAndYear(String actor,int year,Pageable pageRequest);
    List<Movie> findByActress(String actress,Pageable pageRequest);
    List<Movie> findByActressAndActor(String actress, String actor,Pageable pageRequest);
    List<Movie> findByActorAndGenre(String actor,String genre,Pageable pageRequest);
    List<Movie> findByTopRating(float rating, Pageable pageRequest);
    List<Movie> findByTopVotes(int votes,Pageable pageRequest);
    Page<Movie> findAll(Pageable pageable);
//    Movie saveMovie(Movie movie);
//    void deleteMovie(Integer mid);
}
