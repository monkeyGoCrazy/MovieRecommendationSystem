package com.dbms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import com.dbms.domain.Movie;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by mengleisun on 3/14/16.
 */
@Repository
public interface MovieRepository extends PagingAndSortingRepository<Movie, Integer> {
    public Movie findMovieByTitle(@Param("title") String title);

    public Iterable<Movie> findMovieByGenre(@Param("genre") String genre);
    public Iterable<Movie> findMovieByDirector(@Param("director") String director);
    public Iterable<Movie> findByRatingGreaterThan(@Param("rating") float rating);
}