package com.dbms.repositories;

import com.dbms.domain.Actress;
import com.dbms.domain.Movie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by mengleisun on 4/12/16.
 */
@Repository
public interface ActressRepository extends PagingAndSortingRepository<Actress, Integer> {
    @Query("select count (actress) from Actress actress")
    public int findTotal();
}
