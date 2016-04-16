package com.dbms.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by mengleisun on 4/12/16.
 */

@Entity
@XmlRootElement
public class ActorGenreMovie implements Serializable {
    @Id
    private String actor;
    @Id
    private String movie;
    private String genre;
    public void setActor(String actor) {this.actor = actor;}
    public String getActor() { return this.actor; }
    public void setMovie(String movie) { this.movie = movie;}
    public String getMovie() {return this.movie;}
    public void setGenre(String genre) { this.genre = genre;}
    public String getGenre() {return this.genre;}
}
