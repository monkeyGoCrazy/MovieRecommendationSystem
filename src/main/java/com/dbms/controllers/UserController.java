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
    @RequestMapping(value = "/username", method = RequestMethod.GET)
    public @ResponseBody Users getUserMovie(@RequestHeader("Authorization") String sessionId) {
        if (!session.containsKey(sessionId)) {
            return null;
        } else {
            System.out.println(session.get(sessionId)+"11111");
            return userService.findAllInfoByUsername(session.get(sessionId));
        }
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public @ResponseBody boolean login(@RequestHeader("Authorization") String sessionId,@RequestBody Users user) {
        if (userService.matchPassword(user.getUsername(),user.getPassword())) {
            session.put(sessionId,user.getUsername());
            System.out.println(sessionId+" "+user.getUsername());
            return true;
        } else {
            return false;
        }
    }
}
