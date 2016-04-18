package com.dbms.repositories;

import org.springframework.data.jpa.repository.Query;

/**
 * Created by mengleisun on 4/12/16.
 */
public interface ActressGenreMovieRepository {

    @Query("select count (actressGenreMovie) from ActressGenreMovie actressGenreMovie")
    public int findTotal();
}
