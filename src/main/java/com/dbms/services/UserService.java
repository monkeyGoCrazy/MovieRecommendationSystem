package com.dbms.services;

import com.dbms.domain.Users;

/**
 * Created by mengleisun on 4/12/16.
 */


public interface UserService {
    Users findByUsername(String username);
    Iterable<Users> findAll();
    boolean matchPassword(String username, String password);
    Users findAllInfoByUsername(String username);
//    boolean setPassword(String username, String password);
//    boolean insertUser(String username, String password, String email, String firstname, String lastname);
}