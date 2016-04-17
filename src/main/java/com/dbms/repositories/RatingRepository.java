package com.dbms.repositories;

import com.dbms.domain.Rating;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by mengleisun on 4/12/16.
 */
@Repository
public interface RatingRepository extends PagingAndSortingRepository<Rating,Integer> {
    public Rating findRatingByMovietitle(@Param("movietitle") String movietitle);
}
