package com.dbms.repositories;

import com.dbms.domain.Users;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
/**
 * Created by mengleisun on 4/12/16.
 */
@Repository
public interface UsersRepository extends PagingAndSortingRepository<Users,Integer> {

    @Query("select count (users) from Users users")
    public int findTotal();

    @Query("select users from Users users where users.username = :username")
    public Users findByUsername(@Param("username") String username);

    @Query("select users from Users users left join users.userMovies userMovies left join userMovies.movieInfo " +
            "left join users.userActresses userActresses left join users.userActors userActors " +
            "left join users.likeMovies likeMovies left join users.friends friends where " +
            "users.username = :username")
    public Users findAllInfoByUsername(@Param("username") String username);
    //public Iterable<Users> findAll();

//    @Modifying
//    @Query("UPDATE Users U SET U.PASSWORD = :password WHERE U.USERNAME = :username")
//    public boolean setPassword(@Param("username") String username,@Param("password") String password);
//    @Modifying
//    @Query("Insert into Users (username,password,email,firstname,lastname,state) values " +
//            "(:username,:password,:email,:firstname,:lastname,0)")
//    public boolean insertUser(@Param("username") String username, @Param("password")String password,
//                              @Param("email")String email,
//                              @Param("firstname")String firstname, @Param("lastname") String lastname);
}
