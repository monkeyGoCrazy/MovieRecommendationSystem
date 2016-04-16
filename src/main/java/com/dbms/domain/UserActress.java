package com.dbms.domain;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;
/**
 * Created by mengleisun on 4/12/16.
 */
@Entity
@XmlRootElement

public class UserActress implements Serializable {
    @Id
    private String username;
    @Id
    private String actress;
    private Date searchDate;

    public void setUsername(String username) {this.username = username;}
    public String getUsername() { return this.username; }
    public void setActress(String actress) { this.actress = actress;}
    public String getActress() {return this.actress;}
    public void setSearchDate(Date searchDate) { this.searchDate = searchDate;}
    public Date getSearchDate() {return this.searchDate;}
}
