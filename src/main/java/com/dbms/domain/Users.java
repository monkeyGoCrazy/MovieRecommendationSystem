package com.dbms.domain;


import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Set;

/**
 * Created by mengleisun on 4/12/16.
 */
@Entity
@XmlRootElement
@Table(name = "Users")
public class Users {
    @Id
    @Column(name = "username")
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private String email;
    private Integer state;

    @OneToMany(mappedBy="username", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    private Set<UserMovie> userMovies;

    @OneToMany(mappedBy="username", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    private Set<UserActress> userActresses;

    @OneToMany(mappedBy="username", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    private Set<UserActor> userActors;




    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return this.firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return this.lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getState() {
        return this.state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}