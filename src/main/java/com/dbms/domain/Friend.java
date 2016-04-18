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
@Table(name = "Friend")
public class Friend implements Serializable {
    @Id
    @Column(name ="username")
    private String username;

    @Column(name = "friendname")
    private String friendname;

    public void setUsername(String username) {this.username = username;}
    public String getUsername() { return this.username; }
    public void setFriendname(String friendname) { this.friendname = friendname;}
    public String getFriendname() {return this.friendname;}
}
