package com.dbms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dbms.domain.Movie;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by mengleisun on 3/14/16.
 */
@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
    public Movie getMovieByMid(@Param("id") Integer mid);

}