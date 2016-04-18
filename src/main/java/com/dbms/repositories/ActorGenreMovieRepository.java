package com.dbms.repositories;


import com.dbms.domain.ActorGenreMovie;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by mengleisun on 4/12/16.
 */
public interface ActorGenreMovieRepository {

    @Query("select count (actorGenreMovie) from ActorGenreMovie actorGenreMovie")
    public int findTotal();
}
