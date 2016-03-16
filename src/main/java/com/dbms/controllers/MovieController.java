package com.dbms.controllers;

import com.dbms.services.MovieService;
import com.dbms.domain.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by mengleisun on 3/15/16.
 */
@Controller
public class MovieController {
    private MovieService movieService;

    @Autowired
    public void setMovieService(MovieService movieService) {this.movieService = movieService;}

    @RequestMapping(value = "/movie", method = RequestMethod.GET)
    public @ResponseBody Iterable<Movie> list() {
        Iterable<Movie> movies = movieService.listAllMovies();
        return movies;
    }
    @RequestMapping("movie/{id}")
    public @ResponseBody Movie selectMovie(@PathVariable Integer id) {
        Movie movie = movieService.getMovieByMid(id);
        return movie;
    }
}
