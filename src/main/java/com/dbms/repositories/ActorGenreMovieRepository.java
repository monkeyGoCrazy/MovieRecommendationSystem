package com.dbms.repositories;


import com.dbms.domain.ActorGenreMovie;
import com.dbms.domain.Movie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by mengleisun on 4/12/16.
 */
@Repository
public interface ActorGenreMovieRepository extends PagingAndSortingRepository<ActorGenreMovie, Integer> {

    @Query("select count (actorGenreMovie) from ActorGenreMovie actorGenreMovie")
    public int findTotal();
}
