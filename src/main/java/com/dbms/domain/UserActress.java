package com.dbms.domain;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;
/**
 * Created by mengleisun on 4/12/16.
 */
@Entity
@XmlRootElement
@Table(name = "UserActress")
public class UserActress implements Serializable {
    @Id
    @Column(name = "username")
    private String username;
    private String actress;
    @Column(name = "searchdate")
    private Date searchdate;

    public void setUsername(String username) {this.username = username;}
    public String getUsername() { return this.username; }
    public void setActress(String actress) { this.actress = actress;}
    public String getActress() {return this.actress;}
    public void setSearchdate(Date searchdate) { this.searchdate = searchdate;}
    public Date getSearchdate() {return this.searchdate;}
}
