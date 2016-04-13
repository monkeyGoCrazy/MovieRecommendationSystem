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
public class Friend {
    @Id
    private String username;
    @Id
    private String friendname;

    public void setUsername(String username) {this.username = username;}
    public String getUsername() { return this.username; }
    public void setFriendname(String friendname) { this.friendname = friendname;}
    public String getFriendname() {return this.friendname;}
}
