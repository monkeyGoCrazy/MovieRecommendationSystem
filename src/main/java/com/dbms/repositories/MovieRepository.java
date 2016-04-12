package com.dbms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import com.dbms.domain.Movie;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by mengleisun on 3/14/16.
 */
@Repository
public interface MovieRepository extends PagingAndSortingRepository<Movie, Integer> {
    public Movie getMovieByTitle(@Param("title") String title);
    public Iterable<Movie> getMovieByGenre(@Param("genre") String genre);
    public Iterable<Movie> getMovieByDirector(@Param("director") String director);

}