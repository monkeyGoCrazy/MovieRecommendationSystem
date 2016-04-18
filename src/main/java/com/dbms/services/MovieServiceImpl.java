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
    public List<Movie> findAdvancedInfo(String title, String rating, String actor, String director, String company,
                                          String genre, String language, String year, String length, Pageable pageRequest) {
        float rating1 = 0;
        int length1 = 500;
        if (title.equals("undefined")) {
            title = "";
        }
        if (rating.equals("undefined")) {
            rating1 = 0;
        } else {
            rating1 = Float.parseFloat(rating);
        }
        if (actor.equals("undefined")) {
            actor = "";
        }
        if (director.equals("undefined")) {
            director = "";
        }
        if (company.equals("undefined")) {
            company = "";
        }
        if (genre.equals("undefined")) {
            genre = "";
        }
        if (language.equals("undefined")) {
            language = "";
        }
        if (year.equals("undefined")) {
            year = "";
        }
        if (length.equals("undefined")) {
            length1 = 500;
        } else {
            length1 = Integer.parseInt(length);
        }
        return movieRepository.findAdvancedInfo(title,rating1,actor,director,company,genre,language,year,length1,pageRequest);
    }

    @Override
    public List<Movie> findByActorAndDirector(String actor,String director,Pageable pageRequest) {
        return movieRepository.findByActorAndDirector(actor,director,pageRequest);
    }

    @Override
    public List<Movie> findByDirector(String director,Pageable pageRequest) {
        return movieRepository.findByDirector(director,pageRequest);
    }
    @Override
    public List<Movie> findByCompany(String company, Pageable pageRequest) {
        return movieRepository.findByCompany(company,pageRequest);
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
    public List<Movie> findByFuzzyTitle(String title, Pageable pageRequest) {
        return movieRepository.findByFuzzyTitle(title,pageRequest);
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

    @Override
    public List<Movie> findByActorOrActress(String actor,Pageable pageRequest) {
        return movieRepository.findByActorOrActress(actor,pageRequest);
    }
    @Override
    public List<Movie> findByTitleAndRating(String title,float rating,Pageable pageRequest) {
        return movieRepository.findByTitleAndRating(title,rating,pageRequest);
    }
    @Override
    public List<Movie> findByTitleAndActor(String title,String actor,Pageable pageRequest) {
        return movieRepository.findByTitleAndActor(title,actor,pageRequest);
    }
    @Override
    public List<Movie> findByTitleAndDirector(String title,String director,Pageable pageRequest) {
        return movieRepository.findByTitleAndDirector(title,director,pageRequest);
    }
    @Override
    public List<Movie> findByRatingAndActor(float rating, String actor,Pageable pageRequest) {
        return movieRepository.findByRatingAndActor(rating,actor,pageRequest);
    }
    @Override
    public List<Movie> findByRatingAndDirector(float rating, String director, Pageable pageRequest) {
        return movieRepository.findByRatingAndDirector(rating,director,pageRequest);
    }
    @Override
    public List<Movie> findByTitleAndRatingAndActor(String title,float rating, String actor, Pageable pageRequest) {
        return movieRepository.findByTitleAndRatingAndActor(title,rating,actor,pageRequest);
    }
    @Override
    public List<Movie> findByTitleAndRatingAndDirector(String title,float rating,String director, Pageable pageRequest) {
        return movieRepository.findByTitleAndRatingAndDirector(title,rating,director,pageRequest);
    }
    @Override
    public List<Movie> findByTitleAndActorAndDirector(String title,String actor,String director, Pageable pageRequest) {
        return movieRepository.findByTitleAndActorAndDirector(title,actor,director,pageRequest);
    }
    @Override
    public List<Movie> findByRatingAndActorAndDirector(float rating,String actor,String director,Pageable pageRequest) {
        return movieRepository.findByRatingAndActorAndDirector(rating,actor,director,pageRequest);
    }
    public List<Movie> findByTitleAndRatingAndActorAndDirector(String title,float rating, String actor, String director, Pageable pageRequest) {
        return movieRepository.findByTitleAndRatingAndActorAndDirector(title,rating,actor,director,pageRequest);
    }
}
