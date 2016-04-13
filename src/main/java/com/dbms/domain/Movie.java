package com.dbms.domain;

/**
 * Created by mengleisun on 3/14/16.
 */
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Movie {
    private Float rating;
    private String director;
    private String writer;
    private String genre;
    private String language;
    private Integer year;
    @Id
    private String title;
    private String mpaa;
    private Integer length;
    private String budget;
    private String productionCompany;


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
    public String getProductionCompany() { return this.productionCompany;}
    public void setProductionCompany(String productionCompany) { this.productionCompany = productionCompany; }

}
