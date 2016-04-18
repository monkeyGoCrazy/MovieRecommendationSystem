package com.dbms.repositories;

import com.dbms.domain.Movie;
import com.dbms.domain.UserMovie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by mengleisun on 4/12/16.
 */
@Repository
public interface UserMovieRepository extends PagingAndSortingRepository<UserMovie, Integer> {
    @Query("select count (userMovie) from UserMovie userMovie")
    public int findTotal();
}
