package com.dbms.repositories;

import com.dbms.domain.Movie;
import com.dbms.domain.UserActor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by mengleisun on 4/12/16.
 */
@Repository
public interface UserActorRepository extends PagingAndSortingRepository<UserActor, Integer> {
    @Query("select count (userActor) from UserActor userActor")
    public int findTotal();
}
