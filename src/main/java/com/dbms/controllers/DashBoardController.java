package com.dbms.controllers;

import com.dbms.domain.DashBoard;
import com.dbms.domain.Movie;
import com.dbms.services.DashBoardService;
import com.dbms.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by mengleisun on 4/18/16.
 */
@Controller
public class DashBoardController {
    private DashBoardService dashBoardService;

    @Autowired
    public void setDashBoardService(DashBoardService dashBoardService) {this.dashBoardService = dashBoardService;}

    @CrossOrigin(origins = "http://localhost:8080")
    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public @ResponseBody
    DashBoard display() {
        return dashBoardService.displayTotal();
    }
}
