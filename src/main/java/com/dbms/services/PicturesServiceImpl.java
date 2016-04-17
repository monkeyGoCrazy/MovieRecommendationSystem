package com.dbms.services;

import com.dbms.domain.Pictures;
import com.dbms.repositories.PicturesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by mengleisun on 4/16/16.
 */
@Service
public class PicturesServiceImpl implements PicturesService{
    private PicturesRepository movieRepository;

    @Autowired
    public void setMovieRepository(PicturesRepository movieRepository) {
        this.movieRepository = movieRepository;
    }
    @Override
    public Pictures findPicturesByTitle(String title) {
        return movieRepository.findMovieByTitle(title);
    }

}
