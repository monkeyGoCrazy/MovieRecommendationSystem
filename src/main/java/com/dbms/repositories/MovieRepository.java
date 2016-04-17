package com.dbms.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.dbms.domain.Movie;
import org.springframework.data.domain.Pageable;
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
            " where movie.director like CONCAT('%', :director, '%') order by movie.rating desc, movie.title asc")
    public List<Movie> findByDirector(@Param("director") String director, Pageable pageRequest);

    @Query ("select movie from Movie movie join movie.pictures picture" +
            " where movie.company like CONCAT('%', :company, '%') order by movie.rating desc, movie.title asc")
    public List<Movie> findByCompany(@Param("company") String company, Pageable pageRequest);

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
            " where movie.title like CONCAT('%', :title, '%')")
    public List<Movie> findByFuzzyTitle(@Param("title") String title, Pageable pageRequest);

    @Query ("select movie from Movie movie join movie.pictures picture join movie.actorGenreMovie actorGenreMovie" +
            " where actorGenreMovie.actor like CONCAT('%', :actor, '%') order by movie.rating desc, movie.title asc")
    public List<Movie> findByActor(@Param("actor") String actor, Pageable pageRequest);

    @Query ("select movie from Movie movie join movie.pictures picture join movie.actorGenreMovie actorGenreMovie" +
            " where movie.year = :year and actorGenreMovie.actor like CONCAT('%', :actor, '%') order by movie.rating desc, movie.title asc")
    public List<Movie> findByActorAndYear(@Param("actor") String actor, @Param("year") int year, Pageable pageRequest);

    @Query ("select movie from Movie movie join movie.pictures picture join movie.actressGenreMovie actressGenreMovie" +
            " where actressGenreMovie.actress like CONCAT('%', :actress, '%') order by movie.rating desc, movie.title asc")
    public List<Movie> findByActress(@Param("actress") String actress, Pageable pageRequest);

    @Query ("select movie from Movie movie join movie.pictures picture join movie.actressGenreMovie actressGenreMovie" +
            " join movie.actorGenreMovie actorGenreMovie" +
            " where actorGenreMovie.actor like CONCAT('%', :actor, '%') and actressGenreMovie.actress like CONCAT('%', :actress, '%') order by movie.rating desc, movie.title asc")
    public List<Movie> findByActressAndActor(@Param("actress") String actress,@Param("actor") String actor, Pageable pageRequest);

    @Query ("select movie from Movie movie join movie.pictures picture" +
            " join movie.actorGenreMovie actorGenreMovie" +
            " where actorGenreMovie.actor like CONCAT('%', :actor, '%') and actorGenreMovie.genre = :genre order by movie.rating desc, movie.title asc")
    public List<Movie> findByActorAndGenre(@Param("actor") String actor,@Param("genre") String genre, Pageable pageRequest);

    @Query("select movie from Movie movie join movie.pictures pictures join movie.ratings ratings " +
            "where ratings.rating >= :rating AND " +
            "ratings.votes >1000 order by ratings.rating DESC")
    public List<Movie> findByTopRating(@Param("rating") float rating, Pageable pageRequest);

    @Query("select movie from Movie movie join movie.pictures pictures join movie.ratings ratings " +
            "where " +
            "ratings.votes >:votes order by ratings.rating DESC" )
    public List<Movie> findByTopVotes(@Param("votes") int votes, Pageable pageRequest);

    @Query ("select movie from Movie movie join movie.pictures picture join movie.actressGenreMovie actressGenreMovie" +
            " join movie.actorGenreMovie actorGenreMovie" +
            " where actorGenreMovie.actor like CONCAT('%', :actor, '%') and " +
            "actressGenreMovie.actress like CONCAT('%', :actor, '%') " +
            "order by movie.rating desc, movie.title asc")
    public List<Movie> findByActorOrActress(@Param("actor") String actor,Pageable pageRequest);

    @Query ("select movie from Movie movie join movie.pictures picture join movie.actressGenreMovie actressGenreMovie" +
            " join movie.actorGenreMovie actorGenreMovie join movie.ratings ratings" +
            " where movie.title like CONCAT('%', :title, '%') and " +
            "ratings.rating > :rating " +
            "order by movie.rating desc, movie.title asc")
    public List<Movie> findByTitleAndRating(@Param("title") String title,@Param("rating") float rating, Pageable pageRequest);

    @Query ("select movie from Movie movie join movie.pictures picture join movie.actressGenreMovie actressGenreMovie" +
            " join movie.actorGenreMovie actorGenreMovie" +
            " where movie.title like CONCAT('%', :title, '%') and actorGenreMovie.actor like CONCAT('%', :actor, '%') and " +
            "actressGenreMovie.actress like CONCAT('%', :actor, '%') " +
            "order by movie.rating desc, movie.title asc")
    public List<Movie> findByTitleAndActor(@Param("title") String title,@Param("actor") String actor, Pageable pageRequest);

    @Query ("select movie from Movie movie join movie.pictures picture join movie.actressGenreMovie actressGenreMovie" +
            " join movie.actorGenreMovie actorGenreMovie" +
            " where movie.title = :title AND movie.director = :director "+
            "order by movie.rating desc, movie.title asc")
    public List<Movie> findByTitleAndDirector(@Param("title") String title,@Param("director") String director, Pageable pageRequest);

    @Query ("select movie from Movie movie join movie.pictures picture join movie.actressGenreMovie actressGenreMovie" +
            " join movie.actorGenreMovie actorGenreMovie join movie.ratings ratings" +
            " where actorGenreMovie.actor like CONCAT('%', :actor, '%') and " +
            "actressGenreMovie.actress like CONCAT('%', :actor, '%') and ratings.rating > :rating " +
            "order by movie.rating desc, movie.title asc")
    public List<Movie> findByRatingAndActor(@Param("rating") float rating,@Param("actor") String actor, Pageable pageRequest);

    @Query ("select movie from Movie movie join movie.pictures picture join movie.actressGenreMovie actressGenreMovie" +
            " join movie.actorGenreMovie actorGenreMovie join movie.ratings ratings" +
            " where ratings > :rating and movie.director = :director " +
            "order by movie.rating desc, movie.title asc")
    public List<Movie> findByRatingAndDirector(@Param("rating") float rating, @Param("director") String director,Pageable pageRequest);

    @Query ("select movie from Movie movie join movie.pictures picture join movie.actressGenreMovie actressGenreMovie" +
            " join movie.actorGenreMovie actorGenreMovie join movie.ratings ratings" +
            " where actorGenreMovie.actor like CONCAT('%', :actor, '%') and " +
            "actressGenreMovie.actress like CONCAT('%', :actor, '%') and movie.title = :title and ratings.rating >= :rating " +
            "order by movie.rating desc, movie.title asc")
    public List<Movie> findByTitleAndRatingAndActor(@Param("title") String title,@Param("rating") float rating,@Param("actor") String actor, Pageable pageRequest);

    @Query ("select movie from Movie movie join movie.pictures picture join movie.actressGenreMovie actressGenreMovie" +
            " join movie.actorGenreMovie actorGenreMovie join movie.ratings ratings" +
            " where movie.director = :director and movie.title = :title and ratings.rating >= :rating " +
            "order by movie.rating desc, movie.title asc")
    public List<Movie> findByTitleAndRatingAndDirector(@Param("title") String title,@Param("rating") float rating,@Param("director") String director, Pageable pageRequest);

    @Query ("select movie from Movie movie join movie.pictures picture join movie.actressGenreMovie actressGenreMovie" +
            " join movie.actorGenreMovie actorGenreMovie join movie.ratings ratings" +
            " where actorGenreMovie.actor like CONCAT('%', :actor, '%') and " +
            "actressGenreMovie.actress like CONCAT('%', :actor, '%') and movie.title = :title and movie.director = :director " +
            "order by movie.rating desc, movie.title asc")
    public List<Movie> findByTitleAndActorAndDirector(@Param("title") String title,@Param("actor") String actor,@Param("director") String director, Pageable pageRequest);

    @Query ("select movie from Movie movie join movie.pictures picture join movie.actressGenreMovie actressGenreMovie" +
            " join movie.actorGenreMovie actorGenreMovie join movie.ratings ratings" +
            " where actorGenreMovie.actor like CONCAT('%', :actor, '%') and " +
            "actressGenreMovie.actress like CONCAT('%', :actor, '%') and ratings.rating >= :rating and movie.director = :director " +
            "order by movie.rating desc, movie.title asc")
    public List<Movie> findByRatingAndActorAndDirector(@Param("rating") float rating,@Param("actor") String actor,@Param("director") String director, Pageable pageRequest);

    @Query ("select movie from Movie movie join movie.pictures picture join movie.actressGenreMovie actressGenreMovie" +
            " join movie.actorGenreMovie actorGenreMovie join movie.ratings ratings" +
            " where actorGenreMovie.actor like CONCAT('%', :actor, '%') and " +
            "actressGenreMovie.actress like CONCAT('%', :actor, '%') and movie.title = :title and ratings.rating >= :rating and movie.director = :director " +
            "order by movie.rating desc, movie.title asc")
    public List<Movie> findByTitleAndRatingAndActorAndDirector(@Param("title") String title, @Param("rating") float rating,@Param("actor") String actor,@Param("director") String director, Pageable pageRequest);


//    @Query("select movie from Movie movie join movie.pictures pictures where " +
//            "pictures.title = :title")
//    public Iterable<Movie> findMovieWithPictures(@Param("title") String title);

}