package com.dbms.repositories;

import com.dbms.domain.Rating;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by mengleisun on 4/12/16.
 */
@Repository
public interface RatingRepository extends PagingAndSortingRepository<Rating,Integer> {
    @Query("select count (rating) from Rating rating")
    public int findTotal();

    public Rating findRatingByMovietitle(@Param("movietitle") String movietitle);
}
