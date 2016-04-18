package com.dbms.repositories;

import com.dbms.domain.LikeMovie;
import com.dbms.domain.Movie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by mengleisun on 4/12/16.
 */
@Repository
public interface LikeMovieRepository extends PagingAndSortingRepository<LikeMovie, Integer> {
    @Query("select count (likeMovie) from LikeMovie likeMovie")
    public int findTotal();
}
