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
    @RequestMapping("movie/{title}")
    public @ResponseBody Movie selectMoviebyTitle(@PathVariable String title) {
        Movie movie = movieService.getMovieByTitle(title);
        return movie;
    }
    @RequestMapping("movie/genre/{genre}")
    public @ResponseBody Iterable<Movie> selectMovieByGenre(@PathVariable String genre) {
        Iterable<Movie> movies = movieService.getMovieByGenre(genre);
        return movies;
    }
}
