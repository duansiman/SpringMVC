package com.java.web.controller;

import com.java.web.beans.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * Created by devin on 2016/12/26.
 */
@Controller
@RequestMapping(value = "name")
@SessionAttributes(value = "user", types = User.class)
public class AttributeController {

    @RequestMapping("/session")
    @ResponseBody
    public String hello(@RequestParam String name){
        return String.format("hello %s", name);
    }
}
