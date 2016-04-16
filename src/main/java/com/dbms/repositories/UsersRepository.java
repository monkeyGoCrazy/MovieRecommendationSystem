package com.dbms.repositories;

import com.dbms.domain.Users;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
/**
 * Created by mengleisun on 4/12/16.
 */
@Repository
public interface UsersRepository {
    public Users findByUsername(@Param("username") String username);
    public Iterable<Users> findAll();
    public Users findOne();

//    @Modifying
//    @Query("UPDATE Users U SET U.PASSWORD = :password WHERE U.USERNAME = :username")
//    public boolean setPassword(@Param("username") String username,@Param("password") String password);

//    @Query("insert into Users (username,password,email,firstname,lastname) values " +
//            "(:username,:password,:email,:firstname,:lastname)")
//    public boolean insertUser(@Param("username") String username, @Param("password")String password,
//                              @Param("email")String email,
//                              @Param("firstname")String firstname, @Param("lastname") String lastname);
}
