package com.dbms.repositories;

import com.dbms.domain.Discription;
import com.dbms.domain.Movie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by mengleisun on 4/12/16.
 */
public interface DiscriptionRepository extends PagingAndSortingRepository<Discription, Integer> {
    @Query("select count (discription) from Discription discription")
    public int findTotal();
}
