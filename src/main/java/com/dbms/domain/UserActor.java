package com.dbms.domain;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;
import javax.persistence.Id;
import java.util.Date;
/**
 * Created by mengleisun on 4/12/16.
 */
@Entity
@XmlRootElement

public class UserActor {
    @Id
    private String username;
    @Id
    private String actor;
    private Date searchDate;

    public void setUsername(String username) {this.username = username;}
    public String getUsername() { return this.username; }
    public void setActor(String actor) { this.actor = actor;}
    public String getActor() {return this.actor;}
    public void setSearchDate(Date searchDate) { this.searchDate = searchDate;}
    public Date getSearchDate() {return this.searchDate;}
}