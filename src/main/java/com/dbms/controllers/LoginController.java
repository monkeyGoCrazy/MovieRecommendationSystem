package com.dbms.controllers;

import com.dbms.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by mengleisun on 4/12/16.
 */
@Controller
public class LoginController {
    private UserService userService;
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    public boolean login(@RequestBody Users user, HttpSession sessionObj) {
//        System.out.println(user.getUsername());
//        if(userService.matchPassword(user.getUsername(),user.getPassword())) {
//            sessionObj.setAttribute("username",user.getUsername());
//            return true;
//        } else {
//            return false;
//        }
//    }
//    @CrossOrigin(origins = "http://localhost:8080")
//    @RequestMapping(value = "/login/{username}", method = RequestMethod.GET)
//    public Iterable<Urs> getUser(@PathVariable String username) {
//        return userService.findByUsername(username);
//    }
}