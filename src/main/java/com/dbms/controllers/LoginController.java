package com.dbms.controllers;

import com.dbms.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.dbms.domain.Users;

import javax.servlet.http.HttpSession;

/**
 * Created by mengleisun on 4/12/16.
 */
@Controller
public class LoginController {
    private UserService userService;
    @Autowired
    public void setUserService(UserService userService) {this.userService = userService;}
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public boolean login(@RequestBody Users user, HttpSession sessionObj) {
        if(userService.matchPassword(user.getUsername(),user.getPassword())) {
            sessionObj.setAttribute("username",user.getUsername());
            return true;
        } else {
            return false;
        }
    }
}
