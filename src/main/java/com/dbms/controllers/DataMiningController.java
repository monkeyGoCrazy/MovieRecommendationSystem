package com.dbms.controllers;

import com.dbms.domain.*;
import com.dbms.services.DashBoardService;
import com.dbms.services.DataMiningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by mengleisun on 4/18/16.
 */
@Controller
public class DataMiningController {
    private DataMiningService dataMiningService;

    @Autowired
    public void setDataMiningService(DataMiningService dataMiningService) {this.dataMiningService = dataMiningService;}

    @CrossOrigin(origins = "http://localhost:8080")
    @RequestMapping(value = "/datamining/genrecount", method = RequestMethod.GET)
    public @ResponseBody
    Iterable<GenreCount> findGenreCount() {
        return dataMiningService.findGenreCount();
    }
    @CrossOrigin(origins = "http://localhost:8080")
    @RequestMapping(value = "/datamining/languagecount", method = RequestMethod.GET)
    public @ResponseBody
    Iterable<GenreCount> findLanguageCount() {
        return dataMiningService.findLanguageCount();
    }
    @CrossOrigin(origins = "http://localhost:8080")
    @RequestMapping(value = "/datamining/ratinglanguagecount", method = RequestMethod.GET)
    public @ResponseBody
    Iterable<RatingLanguageCount> findRatingLanguageCount() {
        return dataMiningService.findRatingLanguageCount();
    }
    @CrossOrigin(origins = "http://localhost:8080")
    @RequestMapping(value = "/datamining/genrelanguagecount", method = RequestMethod.GET)
    public @ResponseBody
    Iterable<GenreLanguageCount> findGenreLanguageCount() {
        return dataMiningService.findGenreLanguageCount();
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @RequestMapping(value = "/datamining/actoractressdirectorcount", method = RequestMethod.GET)
    public @ResponseBody
    Iterable<ActorActressDirectorCount> findActorActressDirectorCount() {
        return dataMiningService.findActorActressDirectorCount();
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @RequestMapping(value = "/datamining/actoractressgenrecount", method = RequestMethod.GET)
    public @ResponseBody
    Iterable<ActorActressDirectorCount> findActorActressGenreCount() {
        return dataMiningService.findActorActressGenreCount();
    }
    @CrossOrigin(origins = "http://localhost:8080")
    @RequestMapping(value = "/datamining/actorcount", method = RequestMethod.GET)
    public @ResponseBody
    Iterable<GenreCount> findActorCount() {
        return dataMiningService.findActorCount();
    }
    @CrossOrigin(origins = "http://localhost:8080")
    @RequestMapping(value = "/datamining/actresscount", method = RequestMethod.GET)
    public @ResponseBody
    Iterable<GenreCount> findActressCount() {
        return dataMiningService.findActressCount();
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @RequestMapping(value = "/datamining/talentedactor", method = RequestMethod.GET)
    public @ResponseBody
    Iterable<ActorName> findTalentedActor() {
        return dataMiningService.findTalentedActor();
    }

}
