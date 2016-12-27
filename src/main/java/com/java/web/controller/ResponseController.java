package com.java.web.controller;

import com.java.web.beans.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

/**
 * Created by devin on 2016/12/26.
 */
@Controller
public class ResponseController {

    @RequestMapping(value = "/modelAndView")
    public ModelAndView modelAndView(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("modelAndView");
        modelAndView.addObject("user", new User("1", "devin", 18));
        return modelAndView;
    }

}
