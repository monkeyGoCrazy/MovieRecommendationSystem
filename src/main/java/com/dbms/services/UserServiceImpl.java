package com.dbms.services;

import com.dbms.domain.Users;
import com.dbms.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by mengleisun on 4/12/16.
 */
@Service
public class UserServiceImpl implements UserService{
    private UsersRepository usersRepository;

    @Autowired
    public void setUsersRepository(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public Users findAllInfoByUsername(String username) {
        return usersRepository.findAllInfoByUsername(username);
    }

    @Override
    public Users findByUsername(String username) {
        System.out.println(username);
        return usersRepository.findByUsername(username);
    }
    @Override
    public Iterable<Users> findAll() {
        return usersRepository.findAll();
    }
//    @Override
//    public boolean setPassword(String username, String password) {
//        return usersRepository.setPassword(username,password);
//    }
//    @Override
//    public boolean insertUser(String username, String password, String email, String firstname, String lastname){
//        return usersRepository.insertUser(username,password,email,firstname,lastname);
//    }



    @Override
    public boolean matchPassword(String username, String password) {
        Users user = findByUsername(username);
        if (user == null) {
            return false;
        } else if (user.getPassword().equals(password)) {
            return true;
        } else {
            return false;
        }
    }

}
