package com.dbms.repositories;

import com.dbms.domain.Friend;
import com.dbms.domain.Movie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by mengleisun on 4/12/16.
 */
@Repository
public interface FriendRepository extends PagingAndSortingRepository<Friend, Integer> {
    @Query("select count (friend) from Friend friend")
    public int findTotal();
}
