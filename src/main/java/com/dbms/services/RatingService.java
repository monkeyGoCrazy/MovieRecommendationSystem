package com.dbms.services;

import com.dbms.domain.Rating;

/**
 * Created by mengleisun on 4/16/16.
 */
public interface RatingService {
    Rating findRatingByMovietitle(String movie);
}
