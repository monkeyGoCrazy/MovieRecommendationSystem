package com.dbms.repositories;

import com.dbms.domain.Movie;
import com.dbms.domain.UserActress;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by mengleisun on 4/12/16.
 */
@Repository
public interface UserActressRepository extends PagingAndSortingRepository<UserActress, Integer> {
    @Query("select count (userActress) from UserActress userActress")
    public int findTotal();
}
