package com.java.web.controller.async;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Callable;

/**
 * 异步处理
 *
 * Created by devin on 2016/12/29.
 */
@RestController
@RequestMapping(value = "/async")
public class AsyncController {

    @RequestMapping(value = "/callable")
    public Callable<String> callable(){
        return new Callable<String>() {
            public String call() throws Exception {
                Thread.sleep(5000);
                return "hello async";
            }
        };
    }

}
