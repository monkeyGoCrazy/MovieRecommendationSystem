package com.dbms.repositories;

import com.dbms.domain.Pictures;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by mengleisun on 4/12/16.
 */
@Repository
public interface PicturesRepository extends PagingAndSortingRepository<Pictures,Integer> {
    public Pictures findMovieByTitle(@Param("title") String title);
}