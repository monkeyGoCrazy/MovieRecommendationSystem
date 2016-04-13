package com.dbms.services;

/**
 * Created by mengleisun on 4/12/16.
 */
import com.dbms.domain.Users;
public interface UserService {
    Users findByUserName(String username);
    Iterable<Users> findAll();
    boolean setPassword(String username, String password);
    boolean insertUser(String username, String password, String email, String firstname, String lastname);
}
