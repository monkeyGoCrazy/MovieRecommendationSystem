package com.dbms.repositories;

import com.dbms.domain.Pictures;
import org.springframework.data.repository.PagingAndSortingRepository;
import com.dbms.domain.Movie;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by mengleisun on 3/14/16.
 */
@Repository
public interface MovieRepository extends PagingAndSortingRepository<Movie, Integer> {
    public Movie findMovieByTitle(@Param("title") String title);

    @Query ("select movie from Movie movie join movie.pictures picture" +
            " where movie.director like :director order by movie.rating desc, movie.title asc")
    public List<Movie> findByDirector(@Param("director") String director);

    @Query ("select movie from Movie movie join movie.pictures picture" +
            " where movie.company like :company order by movie.rating desc, movie.title asc")
    public List<Movie> findByCompany(@Param("company") String company);

    @Query ("select movie from Movie movie join movie.pictures picture" +
            " where movie.genre = :genre order by movie.rating desc, movie.title asc")
    public List<Movie> findByGenre(@Param("genre") String genre, Pageable pageRequest);

    @Query ("select movie from Movie movie join movie.pictures picture" +
            " where movie.year =:year order by movie.rating desc, movie.title asc")
    public List<Movie> findByYear(@Param("year") int year, Pageable pageRequest);

    @Query ("select movie from Movie movie join movie.pictures picture" +
            " where movie.length >= :length order by movie.rating desc, movie.title asc")
    public List<Movie> findByLength(@Param("length") int length, Pageable pageRequest);

    @Query ("select movie from Movie movie join movie.pictures picture" +
            " where movie.title like :title")
    public List<Movie> findByFuzzyTitle(@Param("title") String title);

    @Query ("select movie from Movie movie join movie.pictures picture join movie.actorGenreMovie actorGenreMovie" +
            " where actorGenreMovie.actor like :actor order by movie.rating desc, movie.title asc")
    public List<Movie> findByActor(@Param("actor") String actor, Pageable pageRequest);

    @Query ("select movie from Movie movie join movie.pictures picture join movie.actorGenreMovie actorGenreMovie" +
            " where movie.year = :year and actorGenreMovie.actor like :actor order by movie.rating desc, movie.title asc")
    public List<Movie> findByActorAndYear(@Param("actor") String actor, @Param("year") int year, Pageable pageRequest);

    @Query ("select movie from Movie movie join movie.pictures picture join movie.actressGenreMovie actressGenreMovie" +
            " where actressGenreMovie.actress like :actress order by movie.rating desc, movie.title asc")
    public List<Movie> findByActress(@Param("actress") String actress, Pageable pageRequest);

    @Query ("select movie from Movie movie join movie.pictures picture join movie.actressGenreMovie actressGenreMovie" +
            " join movie.actorGenreMovie actorGenreMovie" +
            " where actorGenreMovie.actor like :actor and actressGenreMovie.actress like :actress order by movie.rating desc, movie.title asc")
    public List<Movie> findByActressAndActor(@Param("actress") String actress,@Param("actor") String actor, Pageable pageRequest);

    @Query ("select movie from Movie movie join movie.pictures picture" +
            " join movie.actorGenreMovie actorGenreMovie" +
            " where actorGenreMovie.actor like :actor and actorGenreMovie.genre = :genre order by movie.rating desc, movie.title asc")
    public List<Movie> findByActorAndGenre(@Param("actor") String actor,@Param("genre") String genre, Pageable pageRequest);




    @Query("select movie from Movie movie join movie.pictures pictures join movie.ratings ratings " +
            "where ratings.rating >= :rating AND " +
            "ratings.votes >1000 order by ratings.rating DESC")
    public List<Movie> findByTopRating(@Param("rating") float rating, Pageable pageRequest);

    @Query("select movie from Movie movie join movie.pictures pictures join movie.ratings ratings " +
            "where " +
            "ratings.votes >:votes order by ratings.rating DESC" )
    public List<Movie> findByTopVotes(@Param("votes") int votes, Pageable pageRequest);


//    @Query("select movie from Movie movie join movie.pictures pictures where " +
//            "pictures.title = :title")
//    public Iterable<Movie> findMovieWithPictures(@Param("title") String title);

}