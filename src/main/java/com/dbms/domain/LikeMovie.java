package com.dbms.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by mengleisun on 4/12/16.
 */

@Entity
@XmlRootElement
@Table(name = "LikeMovie")
public class LikeMovie implements Serializable {
    @Id
    @Column(name = "username")
    private String username;
   // @Id
    private String movie;
    private Date likedate;

    public void setUsername(String username) {this.username = username;}
    public String getUsername() { return this.username; }
    public void setMovie(String movie) { this.movie = movie;}
    public String getMovie() {return this.movie;}
    public void setLikedate(Date likedate) { this.likedate = likedate;}
    public Date getLikedate() {return this.likedate;}
}
