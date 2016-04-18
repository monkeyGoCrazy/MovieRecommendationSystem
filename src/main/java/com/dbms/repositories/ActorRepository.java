package com.dbms.repositories;

import com.dbms.domain.Actor;
import com.dbms.domain.Movie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by mengleisun on 4/12/16.
 */
@Repository
public interface ActorRepository extends PagingAndSortingRepository<Actor, Integer> {
    @Query("select count (actor) from Actor actor")
    public int findTotal();
}
