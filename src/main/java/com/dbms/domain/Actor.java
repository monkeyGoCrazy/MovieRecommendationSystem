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
public class Actor {
    @Id
    private String actor;
    public void setActor(String actor) {this.actor = actor;}
    public String getActor() { return this.actor; }
}
