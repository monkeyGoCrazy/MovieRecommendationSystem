package com.dbms.controllers;

import com.dbms.services.MovieService;
import com.dbms.domain.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Created by mengleisun on 3/15/16.
 */
@Controller
public class MovieController {
    private MovieService movieService;

    @Autowired
    public void setMovieService(MovieService movieService) {this.movieService = movieService;}

    @CrossOrigin(origins = "http://localhost:8080")
    @RequestMapping(value = "page/{page}", method = RequestMethod.GET)
    public @ResponseBody Page<Movie> findAll(@PathVariable int page) {
        Page<Movie> movies = movieService.findAll(new PageRequest(page,20));
        return movies;
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @RequestMapping(value = "search/title/{title}", method = RequestMethod.GET)
    public @ResponseBody Movie findByTitle(@PathVariable String title) {
        return movieService.findByTitle(title);

    }
    @CrossOrigin(origins = "http://localhost:8080")
    @RequestMapping(value = "search/director/{director}", method = RequestMethod.GET)
    public @ResponseBody List<Movie> findByDirector(@PathVariable String director) {
        return movieService.findByDirector(director);

    }
    @CrossOrigin(origins = "http://localhost:8080")
    @RequestMapping(value = "search/company/{company}", method = RequestMethod.GET)
    public @ResponseBody List<Movie> findByCompany(@PathVariable String company) {
        return movieService.findByCompany(company);

    }
    @CrossOrigin(origins = "http://localhost:8080")
    @RequestMapping(value = "search/genre/{genre}", method = RequestMethod.GET)
    public @ResponseBody List<Movie> findByGenre(@PathVariable String genre) {
        return movieService.findByGenre(genre,new PageRequest(0,20));
    }
    @CrossOrigin(origins = "http://localhost:8080")
    @RequestMapping(value = "search/year/{year}", method = RequestMethod.GET)
    public @ResponseBody List<Movie> findByYear(@PathVariable int year) {
        return movieService.findByYear(year,new PageRequest(0,20));
    }
    @CrossOrigin(origins = "http://localhost:8080")
    @RequestMapping(value = "search/length/{length}", method = RequestMethod.GET)
    public @ResponseBody List<Movie> findByLength(@PathVariable int length) {
        return movieService.findByLength(length,new PageRequest(0,20));
    }
    @CrossOrigin(origins = "http://localhost:8080")
    @RequestMapping(value = "search/fuzzytitle/{fuzzytitle}", method = RequestMethod.GET)
    public @ResponseBody List<Movie> findByFuzzyTitle(@PathVariable String fuzzytitle) {
        return movieService.findByFuzzyTitle(fuzzytitle);
    }
    @CrossOrigin(origins = "http://localhost:8080")
    @RequestMapping(value = "search/actor/{actor}", method = RequestMethod.GET)
    public @ResponseBody List<Movie> findByActor(@PathVariable String actor) {
        return movieService.findByActor(actor,new PageRequest(0,20));
    }
    @CrossOrigin(origins = "http://localhost:8080")
    @RequestMapping(value = "search/actor/{actor}/year/{year}", method = RequestMethod.GET)
    public @ResponseBody List<Movie> findByActorAndYear(@PathVariable("actor") String actor,@PathVariable("year") int year) {
        return movieService.findByActorAndYear(actor,year,new PageRequest(0,20));
    }
    @CrossOrigin(origins = "http://localhost:8080")
    @RequestMapping(value = "search/actress/{actress}", method = RequestMethod.GET)
    public @ResponseBody List<Movie> findByActress(@PathVariable String actress) {
        return movieService.findByActress(actress,new PageRequest(0,20));
    }
    @CrossOrigin(origins = "http://localhost:8080")
    @RequestMapping(value = "search/actress/{actress}/actor/{actor}", method = RequestMethod.GET)
    public @ResponseBody List<Movie> findByActress(@PathVariable("actress") String actress,@PathVariable("actor") String actor) {
        return movieService.findByActressAndActor(actress,actor,new PageRequest(0,20));
    }
    @CrossOrigin(origins = "http://localhost:8080")
    @RequestMapping(value = "search/actor/{actor}/genre/{genre}", method = RequestMethod.GET)
    public @ResponseBody List<Movie> findByActorAndGenre(@PathVariable("actor") String actor,@PathVariable("genre") String genre) {
        return movieService.findByActorAndGenre(actor,genre,new PageRequest(0,20));
    }
    @CrossOrigin(origins = "http://localhost:8080")
    @RequestMapping(value = "search/rating/{rating}", method = RequestMethod.GET)
    public @ResponseBody List<Movie> findByTopRating(@PathVariable("rating") float rating) {
        return movieService.findByTopRating(rating,new PageRequest(0,20));
    }
    @CrossOrigin(origins = "http://localhost:8080")
    @RequestMapping(value = "search/votes/{votes}", method = RequestMethod.GET)
    public @ResponseBody List<Movie> findByTopVotes(@PathVariable("votes") int votes) {
        return movieService.findByTopVotes(votes,new PageRequest(0,20));
    }
    @CrossOrigin(origins = "http://localhost:8080")
    @RequestMapping(value = "/main/", method = RequestMethod.GET)
    public @ResponseBody List<Movie> getUser() {
        return movieService.findByTopRating((float)8.5,new PageRequest(0,10));
    }
}
