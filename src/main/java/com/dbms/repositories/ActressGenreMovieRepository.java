package com.dbms.repositories;

import com.dbms.domain.ActressGenreMovie;
import com.dbms.domain.Movie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by mengleisun on 4/12/16.
 */
@Repository
public interface ActressGenreMovieRepository extends PagingAndSortingRepository<ActressGenreMovie, Integer> {

    @Query("select count (actressGenreMovie) from ActressGenreMovie actressGenreMovie")
    public int findTotal();
}
