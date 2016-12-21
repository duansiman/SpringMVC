package com.java.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by devin on 2016/12/21.
 */
@Controller
public class UserController {

    @RequestMapping(value = "/user/id")
    @ResponseBody
    public String getUser(@RequestParam(value = "id") int id){
        return "user is " + id;
    }

}
