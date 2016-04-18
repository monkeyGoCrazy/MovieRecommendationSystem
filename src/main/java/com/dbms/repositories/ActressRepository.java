package com.dbms.repositories;

import org.springframework.data.jpa.repository.Query;

/**
 * Created by mengleisun on 4/12/16.
 */
public interface ActressRepository {
    @Query("select count (actress) from Actress actress")
    public int findTotal();
}
