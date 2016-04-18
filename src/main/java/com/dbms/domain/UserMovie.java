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
@Table(name = "UserMovie")
public class UserMovie implements Serializable {
    @Id
    @Column(name = "username")
    private String username;
    @Column(name = "movie")
    private String movie;
    @Column(name = "searchdate")
    private Date searchdate;

    @OneToOne()
    @JoinColumn(name="movie",insertable = false, updatable = false)
    private Movie movieInfo;

    public void setMovieInfo(Movie movieInfo) { this.movieInfo = movieInfo;};
    public Movie getMovieInfo() { return movieInfo;}

    public void setUsername(String username) {this.username = username;}
    public String getUsername() { return this.username; }
    public void setMovie(String movie) { this.movie = movie;}
    public String getMovie() {return this.movie;}
    public void setSearchdate(Date searchdate) { this.searchdate = searchdate;}
    public Date getSearchdate() {return this.searchdate;}
}
