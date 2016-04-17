package com.dbms.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.persistence.Id;
import java.util.Date;
/**
 * Created by mengleisun on 4/12/16.
 */
@Entity
@XmlRootElement
@Table(name = "Pictures")
public class Pictures {
    private String image_url;
    @Id
    @Column(name="title")
    private String title;
    private String movie_url;
    public void setImage_url(String image_url) {this.image_url = image_url;}
    public String getImage_url() { return this.image_url; }
    public void setTitle(String title) { this.title = title;}
    public String getTitle() {return this.title;}
    public void setMovie_url(String movie_url) { this.movie_url = movie_url;}
    public String getMovie_url() {return this.movie_url;}
}
