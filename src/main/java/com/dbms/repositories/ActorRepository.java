package com.dbms.repositories;

import org.springframework.data.jpa.repository.Query;

/**
 * Created by mengleisun on 4/12/16.
 */
public interface ActorRepository {
    @Query("select count (actor) from Actor actor")
    public int findTotal();
}
