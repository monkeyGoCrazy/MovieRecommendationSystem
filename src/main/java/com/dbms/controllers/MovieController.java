package com.dbms.controllers;

import com.dbms.services.MovieService;
import com.dbms.domain.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpEntity;
/**
 * Created by mengleisun on 3/15/16.
 */
@Controller
public class MovieController {
    private MovieService movieService;

    @Autowired
    public void setMovieService(MovieService movieService) {this.movieService = movieService;}

    @RequestMapping(value = "/movie/page/{page}", method = RequestMethod.GET)
    public Page<Movie> findAll(@PathVariable int page) {
        Page<Movie> movies = movieService.findAll(new PageRequest(page,20));
        return movies;
    }
    @RequestMapping(value = "movie/title/{title}", method = RequestMethod.GET)
    public @ResponseBody Movie selectMoviebyTitle(@PathVariable String title) {
        Movie movie = movieService.findMovieByTitle(title);
        return movie;
    }
    @RequestMapping(value = "movie/genre/{genre}", method = RequestMethod.GET)
    public @ResponseBody Iterable<Movie> selectMovieByGenre(@PathVariable String genre) {
        Iterable<Movie> movies = movieService.findMovieByGenre(genre);
        return movies;
    }
    @RequestMapping(value = "movie/rating/{rating}", method = RequestMethod.GET)
    public @ResponseBody Iterable<Movie> selectMovieByRating(@PathVariable float rating) {
        Iterable<Movie> movies = movieService.findMovieByRating(rating);
        return movies;
    }
}
