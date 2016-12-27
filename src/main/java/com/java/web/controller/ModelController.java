package com.java.web.controller;

import com.java.web.beans.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Model使用
 * Created by devin on 2016/12/26.
 */
@Controller
@RequestMapping(value = "/model")
public class ModelController {

//    @ModelAttribute
//    public User getUser(){
//        return new User("2", "jack", 23);
//    }

//    @ModelAttribute
//    public void getUser(Model model){
//        model.addAttribute("user", new User("2", "jack", 23));
//    }

    @RequestMapping(value = "/user")
    @ModelAttribute
    public User user(){
        return new User("2", "jack", 23);
    }

    @RequestMapping(value = "/student")
    public String student(){
        return "model";
    }

    @RequestMapping(value = "/setUser")
    public String user(@ModelAttribute User user){
        System.out.println(user.id+","+user.name+","+user.age);
        return "user";
    }

    @RequestMapping(value = "/user/{id}")
    public String setUserId(@ModelAttribute User user){
        user.name = "devin";
        user.age = 12;
        return "user";
    }

    @RequestMapping(value = "/user/bind")
    public String user(@ModelAttribute User user, BindingResult result){
        if (result.hasErrors()) {
            return "error";
        }
        System.out.println(user.id+","+user.name+","+user.age);
        return "user";
    }

}
