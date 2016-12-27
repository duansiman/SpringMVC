package com.java.web.controller.view;

import com.fasterxml.jackson.annotation.JsonView;
import com.java.web.beans.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by devin on 2016/12/27.
 */
@RestController
@RequestMapping(value = "/view/jackson")
public class JacksonController {

    @RequestMapping(value = "/getUser")
    @JsonView(User.UserView.class)
    public User getUser(){
        return new User("3", "jack", 18);
    }

    // TODO: 2016/12/27 使用@Controller Problem accessing /view/model/userView
    // TODO: 2016/12/27 @RestController 直接返回userView
    @RequestMapping(value = "/model/getUser")
    public String getUser(Model model){
        model.addAttribute("user", new User("3", "jack", 18));
        model.addAttribute(JsonView.class.getName(), User.UserView.class);
        return "userView";
    }

}
