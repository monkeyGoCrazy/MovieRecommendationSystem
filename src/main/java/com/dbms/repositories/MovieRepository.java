package com.dbms.repositories;

import com.dbms.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.Iterator;
import java.util.List;

/**
 * Created by mengleisun on 3/14/16.
 */
@Repository
public interface MovieRepository extends PagingAndSortingRepository<Movie, Integer> {
    public Movie findMovieByTitle(@Param("title") String title);

    @Query("select count (movie) from Movie movie")
    public int findTotal();

    @Query("select movie.genre,count(movie)*100.0/25909 as percentage from Movie movie " +
            "group by movie.genre order by percentage DESC")
    public Iterable<GenreCount> findGenreCount();

    @Query("select movie.language,count(movie)*100.0/25909 as percentage from Movie movie " +
            "group by movie.language order by percentage DESC")
    public Iterable<GenreCount> findlanguageCount();

    @Query("select movie.rating,movie.language,count(movie) as num from Movie movie " +
            "where movie.rating >= 8 group by movie.rating, movie.language order by movie.rating desc, num desc")
    public Iterable<RatingLanguageCount> findRatingLanguageCount();

    @Query("select movie.genre,movie.language,count(movie) as num from Movie movie " +
            "where movie.rating >= 8 group by movie.genre, movie.language order by num desc")
    public Iterable<GenreLanguageCount> findGenreLanguageCount();

    @Query("select actorGenreMovie.actor, count(actorGenreMovie) as num " +
            "from Movie movie " +
            "join movie.actorGenreMovie actorGenreMovie " +
            "group by actorGenreMovie.actor " +
            "having count(movie) > 100 " +
            "order by num desc")
    public Iterable<GenreCount> findActorCount();

    @Query("select actressGenreMovie.actress, count(actressGenreMovie) as num " +
            "from Movie movie " +
            "join movie.actressGenreMovie actressGenreMovie " +
            "group by actressGenreMovie.actress " +
            "having count(movie) > 20 " +
            "order by num desc")
    public Iterable<GenreCount> findActressCount();

    @Query("select distinct a1.actor " +
            "from Movie m1 " +
            "join m1.actorGenreMovie a1 " +
            "where a1.actor in (select a2.actor " +
            "from Movie m2 " +
            "join m2.actorGenreMovie a2 " +
            "where a2.actor in (select a3.actor " +
            "from Movie m3 " +
            "join m3.actorGenreMovie a3 " +
            "group by a3.actor " +
            "having count(distinct m3.genre) > 15) "+
            "and not exists " +
            "(select distinct a4.actor " +
            "from Movie m4 " +
            "join m4.actorGenreMovie a4 " +
            "where a4.actor in (select a5.actor " +
            "from Movie m5 " +
            "join m5.actorGenreMovie a5 " +
            "where m5.rating < 3) " +
            "and a1.actor = a4.actor))")
    public Iterable<ActorName> findTalentedActor();

    @Query("select actorGenreMovie.actor,actressGenreMovie.actress, movie.genre, count(movie) as num " +
            "from Movie movie " +
            "join movie.actressGenreMovie actressGenreMovie " +
            "join movie.actorGenreMovie actorGenreMovie " +
            "group by actorGenreMovie.actor, actressGenreMovie.actress, movie.genre " +
            "having count(movie) > 10 " +
            "order by num desc")
    public Iterable<ActorActressDirectorCount> findActorActressGenreCount();

    @Query("select actorGenreMovie.actor,actressGenreMovie.actress,movie.director,count(movie) as num " +
            "from Movie movie " +
            "join movie.actressGenreMovie actressGenreMovie " +
            "join movie.actorGenreMovie actorGenreMovie " +
            "group by actorGenreMovie.actor, actressGenreMovie.actress, movie.director " +
            "having count(distinct movie.company) > 2 and count(movie) > 4 " +
            "order by num desc")
    public Iterable<ActorActressDirectorCount> findActorActressDirectorCount();

    @Query ("select distinct movie from Movie movie join movie.pictures picture join movie.actressGenreMovie actressGenreMovie" +
            " join movie.actorGenreMovie actorGenreMovie join movie.ratings ratings" +
            " where (actorGenreMovie.actor like CONCAT('%', :actor, '%') or " +
            "actressGenreMovie.actress like CONCAT('%', :actor, '%')) and " +
            "movie.title like CONCAT('%', :title, '%') and " +
            "ratings.rating >= :rating and " +
            "movie.director like CONCAT('%', :director, '%') and " +
            "movie.company like CONCAT('%', :company, '%') and " +
            "movie.genre like CONCAT('%', :genre, '%') and " +
            "movie.language like CONCAT('%', :language, '%') and " +
            "movie.year like CONCAT('%', :year, '%') and " +
            "movie.length < :length " +
            "order by movie.rating desc, movie.title asc")
    public List<Movie> findAdvancedInfo(@Param("title") String title,
                                        @Param("rating") float rating,
                                        @Param("actor") String actor,
                                        @Param("director") String director,
                                        @Param("company") String company,
                                        @Param("genre") String genre,
                                        @Param("language") String language,
                                        @Param("year") String year,
                                        @Param("length") int length,
                                        Pageable pageRequest);

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

    @Query ("select distinct movie from Movie movie join movie.pictures picture join movie.actorGenreMovie actorGenreMovie" +
            " where actorGenreMovie.actor like CONCAT('%', :actor, '%') order by movie.rating desc, movie.title asc")
    public List<Movie> findByActor(@Param("actor") String actor, Pageable pageRequest);

    @Query ("select distinct movie from Movie movie join movie.pictures picture join movie.actorGenreMovie actorGenreMovie" +
            " where movie.year = :year and actorGenreMovie.actor like CONCAT('%', :actor, '%') order by movie.rating desc, movie.title asc")
    public List<Movie> findByActorAndYear(@Param("actor") String actor, @Param("year") int year, Pageable pageRequest);

    @Query ("select distinct movie from Movie movie join movie.pictures picture join movie.actressGenreMovie actressGenreMovie" +
            " where actressGenreMovie.actress like CONCAT('%', :actress, '%') order by movie.rating desc, movie.title asc")
    public List<Movie> findByActress(@Param("actress") String actress, Pageable pageRequest);

    @Query ("select distinct movie from Movie movie join movie.pictures picture join movie.actressGenreMovie actressGenreMovie" +
            " join movie.actorGenreMovie actorGenreMovie" +
            " where actorGenreMovie.actor like CONCAT('%', :actor, '%') and actressGenreMovie.actress like CONCAT('%', :actress, '%') order by movie.rating desc, movie.title asc")
    public List<Movie> findByActressAndActor(@Param("actress") String actress,@Param("actor") String actor, Pageable pageRequest);

    @Query ("select distinct movie from Movie movie join movie.pictures picture" +
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

    @Query ("select distinct movie from Movie movie join movie.pictures picture join movie.actressGenreMovie actressGenreMovie" +
            " join movie.actorGenreMovie actorGenreMovie" +
            " where (actorGenreMovie.actor like CONCAT('%', :actor, '%') or " +
            "actressGenreMovie.actress like CONCAT('%', :actor, '%')) " +
            "order by movie.rating desc, movie.title asc")
    public List<Movie> findByActorOrActress(@Param("actor") String actor,Pageable pageRequest);

    @Query ("select distinct movie from Movie movie join movie.pictures picture join movie.actressGenreMovie actressGenreMovie" +
            " join movie.actorGenreMovie actorGenreMovie join movie.ratings ratings" +
            " where movie.title like CONCAT('%', :title, '%') and " +
            "ratings.rating > :rating " +
            "order by movie.rating desc, movie.title asc")
    public List<Movie> findByTitleAndRating(@Param("title") String title,@Param("rating") float rating, Pageable pageRequest);

    @Query ("select distinct movie from Movie movie join movie.pictures picture join movie.actressGenreMovie actressGenreMovie" +
            " join movie.actorGenreMovie actorGenreMovie" +
            " where movie.title like CONCAT('%', :title, '%') and (actorGenreMovie.actor like CONCAT('%', :actor, '%') or " +
            "actressGenreMovie.actress like CONCAT('%', :actor, '%')) " +
            "order by movie.rating desc, movie.title asc")
    public List<Movie> findByTitleAndActor(@Param("title") String title,@Param("actor") String actor, Pageable pageRequest);

    @Query ("select distinct movie from Movie movie join movie.pictures picture join movie.actressGenreMovie actressGenreMovie" +
            " join movie.actorGenreMovie actorGenreMovie" +
            " where movie.director like CONCAT('%', :director, '%') and (actorGenreMovie.actor like CONCAT('%', :actor, '%') or " +
            "actressGenreMovie.actress like CONCAT('%', :actor, '%')) " +
            "order by movie.rating desc, movie.title asc")
    public List<Movie> findByActorAndDirector(@Param("actor") String actor,@Param("director") String director, Pageable pageRequest);

    @Query ("select distinct movie from Movie movie join movie.pictures picture join movie.actressGenreMovie actressGenreMovie" +
            " join movie.actorGenreMovie actorGenreMovie" +
            " where movie.title = :title AND movie.director like CONCAT('%', :director, '%') "+
            "order by movie.rating desc, movie.title asc")
    public List<Movie> findByTitleAndDirector(@Param("title") String title,@Param("director") String director, Pageable pageRequest);

    @Query ("select distinct movie from Movie movie join movie.pictures picture join movie.actressGenreMovie actressGenreMovie" +
            " join movie.actorGenreMovie actorGenreMovie join movie.ratings ratings" +
            " where (actorGenreMovie.actor like CONCAT('%', :actor, '%') or " +
            "actressGenreMovie.actress like CONCAT('%', :actor, '%')) and ratings.rating > :rating " +
            "order by movie.rating desc, movie.title asc")
    public List<Movie> findByRatingAndActor(@Param("rating") float rating,@Param("actor") String actor, Pageable pageRequest);

    @Query ("select distinct movie from Movie movie join movie.pictures picture join movie.actressGenreMovie actressGenreMovie" +
            " join movie.actorGenreMovie actorGenreMovie join movie.ratings ratings" +
            " where ratings.rating >= :rating and movie.director like CONCAT('%', :director, '%') " +
            "order by movie.rating desc, movie.title asc")
    public List<Movie> findByRatingAndDirector(@Param("rating") float rating, @Param("director") String director,Pageable pageRequest);

    @Query ("select distinct movie from Movie movie join movie.pictures picture join movie.actressGenreMovie actressGenreMovie" +
            " join movie.actorGenreMovie actorGenreMovie join movie.ratings ratings" +
            " where (actorGenreMovie.actor like CONCAT('%', :actor, '%') or " +
            "actressGenreMovie.actress like CONCAT('%', :actor, '%')) and movie.title like CONCAT('%', :title, '%') and ratings.rating >= :rating " +
            "order by movie.rating desc, movie.title asc")
    public List<Movie> findByTitleAndRatingAndActor(@Param("title") String title,@Param("rating") float rating,@Param("actor") String actor, Pageable pageRequest);

    @Query ("select distinct movie from Movie movie join movie.pictures picture join movie.actressGenreMovie actressGenreMovie" +
            " join movie.actorGenreMovie actorGenreMovie join movie.ratings ratings" +
            " where movie.director like CONCAT('%', :director, '%') and movie.title like CONCAT('%', :title, '%') and ratings.rating >= :rating " +
            "order by movie.rating desc, movie.title asc")
    public List<Movie> findByTitleAndRatingAndDirector(@Param("title") String title,@Param("rating") float rating,@Param("director") String director, Pageable pageRequest);

    @Query ("select distinct movie from Movie movie join movie.pictures picture join movie.actressGenreMovie actressGenreMovie" +
            " join movie.actorGenreMovie actorGenreMovie join movie.ratings ratings" +
            " where (actorGenreMovie.actor like CONCAT('%', :actor, '%') or " +
            "actressGenreMovie.actress like CONCAT('%', :actor, '%')) and movie.title like CONCAT('%', :title, '%') and movie.director like CONCAT('%', :director, '%') " +
            "order by movie.rating desc, movie.title asc")
    public List<Movie> findByTitleAndActorAndDirector(@Param("title") String title,@Param("actor") String actor,@Param("director") String director, Pageable pageRequest);

    @Query ("select distinct movie from Movie movie join movie.pictures picture join movie.actressGenreMovie actressGenreMovie" +
            " join movie.actorGenreMovie actorGenreMovie join movie.ratings ratings" +
            " where (actorGenreMovie.actor like CONCAT('%', :actor, '%') or " +
            "actressGenreMovie.actress like CONCAT('%', :actor, '%')) and ratings.rating >= :rating and movie.director like CONCAT('%', :director, '%') " +
            "order by movie.rating desc, movie.title asc")
    public List<Movie> findByRatingAndActorAndDirector(@Param("rating") float rating,@Param("actor") String actor,@Param("director") String director, Pageable pageRequest);

    @Query ("select distinct movie from Movie movie join movie.pictures picture join movie.actressGenreMovie actressGenreMovie" +
            " join movie.actorGenreMovie actorGenreMovie join movie.ratings ratings" +
            " where (actorGenreMovie.actor like CONCAT('%', :actor, '%') or " +
            "actressGenreMovie.actress like CONCAT('%', :actor, '%')) and movie.title like CONCAT('%', :title, '%') and ratings.rating >= :rating and movie.director like CONCAT('%', :director, '%') " +
            "order by movie.rating desc, movie.title asc")
    public List<Movie> findByTitleAndRatingAndActorAndDirector(@Param("title") String title, @Param("rating") float rating,@Param("actor") String actor,@Param("director") String director, Pageable pageRequest);


//    @Query("select movie from Movie movie join movie.pictures pictures where " +
//            "pictures.title = :title")
//    public Iterable<Movie> findMovieWithPictures(@Param("title") String title);

}