package com.dbms.controllers;

import com.dbms.domain.Users;
import com.dbms.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.HashMap;

/**
 * Created by mengleisun on 3/16/16.
 */
@Controller
public class UserController {
    private UserService userService;
    private HashMap<String,String> session = new HashMap<String,String>();
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    @CrossOrigin(origins = "http://localhost:8080")
    @RequestMapping(value = "user/username/{username}", method = RequestMethod.GET)
    public @ResponseBody Users getUser(@PathVariable String username) {
        return userService.findByUsername(username);
    }
    @CrossOrigin(origins = "http://localhost:8080")
    @RequestMapping(value = "user/usermovie/{username}", method = RequestMethod.GET)
    public @ResponseBody Users getUserMovie(@PathVariable String username) {
        return userService.findByUsername(username);
    }
    @CrossOrigin(origins = "http://localhost:8080")
    @RequestMapping(value = "user/usermovie/{username}", method = RequestMethod.GET)
    public @ResponseBody Users getUserFriend(@PathVariable String username) {
        return userService.findByUsername(username);
    }


    @CrossOrigin(origins = "http://localhost:8080")
    @RequestMapping(value = "/login/username/{username}/password/{password}", method = RequestMethod.GET)
    public @ResponseBody boolean login(@RequestHeader("Authorization") String sessionId, @PathVariable("username") String username, @PathVariable("password") String password) {
        if (userService.matchPassword(username,password)) {
            session.put(sessionId,username);
            return true;
        } else {
            return false;
        }
    }
}
