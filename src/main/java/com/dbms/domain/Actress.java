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
public class Actress {
    private String actress;
    public void setActress(String actress) {this.actress = actress;}
    public String getActress() { return this.actress; }
}
