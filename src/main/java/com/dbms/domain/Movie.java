package com.dbms.domain;

/**
 * Created by mengleisun on 3/14/16.
 */

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
import java.util.Set;

@Entity
@XmlRootElement
@Table(name = "Movie")
public class Movie {
    @Id
    @Column(name="title")
    private String title;
    private Float rating;
    private String director;
    private String writer;
    private String genre;
    private String language;
    private Integer year;
    private String mpaa;
    private Integer length;
    private String budget;
    private String company;

    @OneToOne()
    @JoinColumn(name="title",referencedColumnName = "title")
    private Pictures pictures;

    @OneToOne()
    @JoinColumn(name="title",referencedColumnName = "movietitle")
    private Rating ratings;

    @OneToMany(mappedBy="movie", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    private Set<ActorGenreMovie> actorGenreMovie;

    @OneToMany(mappedBy="movie", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    private Set<ActressGenreMovie> actressGenreMovie;

    public void setActressGenreMovie(Set<ActressGenreMovie> actressGenreMovie) {this.actressGenreMovie = actressGenreMovie;}
    public Set<ActressGenreMovie> getActressGenreMovie() {return actressGenreMovie;}

    public void setActorGenreMovie(Set<ActorGenreMovie> actorGenreMovie) {this.actorGenreMovie = actorGenreMovie;}
    public Set<ActorGenreMovie> getActorGenreMovie() {return actorGenreMovie;}

    public void setRatings(Rating ratings) {this.pictures = pictures;}
    public Rating getRatings() {return ratings;}

    public void setPictures(Pictures pictures) {this.pictures = pictures;}
    public Pictures getPictures() {return this.pictures;}
    public void setRating(Float rating) {
        this.rating = rating;
    }
    public Float getRating() {return this.rating;}
    public String getDirector() {
        return this.director;
    }
    public void setDirector(String director) {this.director = director; }
    public String getWriter() { return this.writer;}
    public void setWriter(String writer) { this.writer = writer; }
    public String getGenre() { return this.genre; }
    public void setGenre(String genre) {this.genre = genre; }
    public String getLanguage() { return this.language;}
    public void setLanguage(String language) { this.language = language; }
    public Integer getYear() { return this.year; }
    public void setYear(Integer year) { this.year = year; }
    public String getTitle() { return this.title; }
    public void setTitle(String title) { this.title = title; }
    public String getMpaa() { return this.mpaa;}
    public void setMpaa(String mpaa) { this.mpaa = mpaa; }
    public Integer getLength () {return this.length; }
    public void setLength(Integer length) {this.length = length; }
    public String getBudget() { return this.budget; }
    public void setBudget(String budget) { this.budget = budget; }
    public String getCompany() { return this.company;}
    public void setCompany(String company) { this.company = company; }

}
