package com.dbms.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * Created by mengleisun on 4/12/16.
 */

@Entity
@XmlRootElement
public class ActressGenreMovie {
    @Id
    private String actress;
    @Id
    private String movie;
    private String genre;
    public void setActress(String actress) {this.actress = actress;}
    public String getActress() { return this.actress; }
    public void setMovie(String movie) { this.movie = movie;}
    public String getMovie() {return this.movie;}
    public void setGenre(String genre) { this.genre = genre;}
    public String getGenre() {return this.genre;}
}
