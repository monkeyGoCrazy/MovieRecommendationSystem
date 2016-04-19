package com.dbms.services;

import com.dbms.domain.*;
import com.dbms.repositories.MovieRepository;
import com.fasterxml.jackson.databind.ser.std.IterableSerializer;
import com.sun.tools.javac.jvm.Gen;
import com.sun.xml.internal.bind.annotation.OverrideAnnotationOf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by mengleisun on 4/18/16.
 */
@Service
public class DataMiningServiceImpl implements DataMiningService {
    private MovieRepository movieRepository;
    @Autowired
    public void setMovieRepository(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }
    @Override
    public Iterable<GenreCount> findGenreCount() {
        return movieRepository.findGenreCount();
    }
    @Override
    public Iterable<GenreCount> findLanguageCount() {
        return movieRepository.findlanguageCount();
    }
    @Override
    public Iterable<RatingLanguageCount> findRatingLanguageCount() {
        return movieRepository.findRatingLanguageCount();
    }
    @Override
    public Iterable<GenreLanguageCount> findGenreLanguageCount() {
        return movieRepository.findGenreLanguageCount();
    }
    @Override
    public Iterable<ActorActressDirectorCount> findActorActressDirectorCount() {
        return movieRepository.findActorActressDirectorCount();
    }
    @Override
    public Iterable<ActorActressDirectorCount> findActorActressGenreCount() {
        return movieRepository.findActorActressGenreCount();
    }
    @Override
    public Iterable<GenreCount> findActorCount() {
        return movieRepository.findActorCount();
    }
    @Override
    public Iterable<GenreCount> findActressCount() {
        return movieRepository.findActressCount();
    }
    @Override
    public Iterable<ActorName> findTalentedActor() {
        return movieRepository.findTalentedActor();
    }
}
