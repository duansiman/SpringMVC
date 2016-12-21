package com.java.web.controller;

import com.java.web.beans.User;
import com.java.web.beans.UserEditor;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by devin on 2016/12/21.
 */
@Controller
public class ParamController {

    @RequestMapping(value = "/reqresp")
    public void reqAndResp(HttpServletRequest request, HttpServletResponse response){
        System.out.println(request.getPathInfo());
        response.addHeader("myHeader", "myValue");
        try {
            response.getWriter().write("reqAndResp");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/rdrwtr")
    @ResponseBody
    public String redAndWriter(Reader reader){// TODO: 2016/12/21 没有东西输出
        char[] buf = new char[1024];
        int size = 0;
        try {
            while ((size = reader.read(buf))!= -1) {
                System.out.println(new String(buf, 0, size));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redAndWriter";
    }

//    @RequestMapping(value = "/getUserById/{date}")
//    @ResponseBody
    public String getUserById(@PathVariable("date") Date date){
        return date.toString();
    }

    @RequestMapping(value = "/getUserById/{id}")
    @ResponseBody
    public String getUserById(@PathVariable("id") User user){// TODO: 2016/12/21 这样不行
        return user.toString();
    }


    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyyMMdd"), false));
        binder.registerCustomEditor(User.class, new UserEditor());

    }
}
