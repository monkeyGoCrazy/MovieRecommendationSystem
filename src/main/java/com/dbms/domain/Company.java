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
public class Company {
    @Id
    private String name;
    private String discription;

    public void setTitle(String title) {this.name = title;}
    public String getTitle() { return this.name; }
    public void setDiscription(String discription) { this.discription = discription;}
    public String getDiscription() {return this.discription;}
}