package com.dbms.services;

import com.dbms.domain.Pictures;

/**
 * Created by mengleisun on 4/16/16.
 */
public interface PicturesService {
    Pictures findPicturesByTitle(String title);
}
