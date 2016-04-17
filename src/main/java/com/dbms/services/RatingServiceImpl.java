package com.dbms.services;

import com.dbms.domain.Rating;
import com.dbms.repositories.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by mengleisun on 4/16/16.
 */
@Service
public class RatingServiceImpl implements RatingService{
    private RatingRepository ratingRepository;

    @Autowired
    public void setMovieRepository(RatingRepository RatingRepository) {
        this.ratingRepository = RatingRepository;
    }
    @Override
    public Rating findRatingByMovietitle(String movietitle) {
        return ratingRepository.findRatingByMovietitle(movietitle);
    }

}
