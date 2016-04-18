package com.dbms.domain;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by mengleisun on 4/12/16.
 */

@Entity
@XmlRootElement
@Table(name = "ActressGenreMovie")
public class ActressGenreMovie implements Serializable {
    @Id
    private String actress;
  //  @Id
    @Column(name = "movie")
    private String movie;
    private String genre;

//    @ManyToOne(fetch = FetchType.LAZY)
//    private Movie movie1;
//    public void setMovie1(Movie movie1) {this.movie1 = movie1;}
//    public Movie getMovie1() { return this.movie1; }
    public void setActress(String actress) {this.actress = actress;}
    public String getActress() { return this.actress; }
    public void setMovie(String movie) { this.movie = movie;}
    public String getMovie() {return this.movie;}
    public void setGenre(String genre) { this.genre = genre;}
    public String getGenre() {return this.genre;}
}
