package com.java.web.controller;

import com.java.web.beans.User;
import com.java.web.beans.UserEditor;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @InitBinder 使用
 * Created by devin on 2016/12/28.
 */
@Controller
@RequestMapping(value = "/binding")
public class DataBindingController {

    @RequestMapping(value = "/date/{date}")
    @ResponseBody
    public String getUserById(@PathVariable("date") Date date){
        return date.toString();
    }

    @RequestMapping(value = "/user/{id}", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String getUserById(@PathVariable("id") User user){
        return user.toString();
    }

    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyyMMdd"), false));
        binder.registerCustomEditor(User.class, new UserEditor());
    }

}
