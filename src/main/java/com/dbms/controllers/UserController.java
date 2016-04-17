package com.dbms.controllers;

import com.dbms.domain.Users;
import com.dbms.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

/**
 * Created by mengleisun on 3/16/16.
 */
@Controller
public class UserController {
    private UserService userService;
    @CrossOrigin(origins = "http://localhost:8080")
    @RequestMapping(value = "/username/{username}", method = RequestMethod.GET)
    public @ResponseBody
    Users getUser(@PathVariable String username) {
        return userService.findByUsername(username);
    }
}
