package com.dbms.services;

import com.dbms.domain.*;
import com.fasterxml.jackson.databind.ser.std.IterableSerializer;

/**
 * Created by mengleisun on 4/18/16.
 */
public interface DataMiningService {
    Iterable<GenreCount> findGenreCount();
    Iterable<GenreCount> findLanguageCount();
    Iterable<RatingLanguageCount> findRatingLanguageCount();
    Iterable<GenreLanguageCount> findGenreLanguageCount();
    Iterable<ActorActressDirectorCount> findActorActressDirectorCount();
    Iterable<ActorActressDirectorCount> findActorActressGenreCount();
    Iterable<GenreCount> findActorCount();
    Iterable<GenreCount> findActressCount();
    Iterable<ActorName> findTalentedActor();
}
