package com.java.web.controller.view;

import com.java.web.beans.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by devin on 2016/12/27.
 */
@Controller
@RequestMapping(value = "/view")
public class ViewController {

    @ModelAttribute(value = "user")
    public User user(){
        return new User("3", "jack", 18);
    }

    @RequestMapping(value = "/getUser")
    public String getUser(){
        return "user.jsp";
    }

}
