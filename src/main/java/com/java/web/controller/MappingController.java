package com.java.web.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by devin on 2016/12/21.
 */
@Controller
@RequestMapping(value = "/mapping")
public class MappingController {

    @RequestMapping(value = "/test")
    @ResponseBody
    public String test(){
        return "test";
    }

    @RequestMapping(value = "/test2", method = RequestMethod.GET,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE,
            params = "myParam=myValue", headers = "myHeader=myValue")
    @ResponseBody
    public String test2(){
        return "test2";
    }

    @RequestMapping(value = "/test3", method = RequestMethod.GET,
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseBody
    public String test3(){
        return "test3";
    }

}
