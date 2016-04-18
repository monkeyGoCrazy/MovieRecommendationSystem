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
    List<Movie> findByActorAndDirector(String actor,String director,Pageable pageRequest);
    List<Movie> findByDirector(String director, Pageable pageRequest);
    List<Movie> findByCompany(String company, Pageable pageRequest);
    List<Movie> findByGenre(String genre, Pageable pageRequest);
    List<Movie> findByYear(int year, Pageable pageRequest);
    List<Movie> findByLength(int length,Pageable pageRequest);
    List<Movie> findByFuzzyTitle(String title, Pageable pageRequest);
    List<Movie> findByActor(String actor, Pageable pageRequest);
    List<Movie> findByActorAndYear(String actor,int year,Pageable pageRequest);
    List<Movie> findByActress(String actress,Pageable pageRequest);
    List<Movie> findByActressAndActor(String actress, String actor,Pageable pageRequest);
    List<Movie> findByActorAndGenre(String actor,String genre,Pageable pageRequest);
    List<Movie> findByTopRating(float rating, Pageable pageRequest);
    List<Movie> findByTopVotes(int votes,Pageable pageRequest);
    Page<Movie> findAll(Pageable pageable);
    List<Movie> findByActorOrActress(String actor,Pageable pageRequest);
    List<Movie> findByTitleAndRating(String title,float rating,Pageable pageRequest);
    List<Movie> findByTitleAndActor(String title,String actor,Pageable pageRequest);
    List<Movie> findByTitleAndDirector(String title,String director,Pageable pageRequest);
    List<Movie> findByRatingAndActor(float rating, String actor,Pageable pageRequest);
    List<Movie> findByRatingAndDirector(float rating, String director, Pageable pageRequest);
    List<Movie> findByTitleAndRatingAndActor(String title,float rating, String actor, Pageable pageRequest);
    List<Movie> findByTitleAndRatingAndDirector(String title,float rating,String director, Pageable pageRequest);
    List<Movie> findByTitleAndActorAndDirector(String title,String actor,String director, Pageable pageRequest);
    List<Movie> findByRatingAndActorAndDirector(float rating,String actor,String director,Pageable pageRequest);
    List<Movie> findByTitleAndRatingAndActorAndDirector(String title,float rating, String actor, String director, Pageable pageRequest);
    List<Movie> findAdvancedInfo(String title, String rating, String actor, String director, String company,
                                 String genre, String language, String year, String length, Pageable pageRequest);

//    Movie saveMovie(Movie movie);
//    void deleteMovie(Integer mid);
}
