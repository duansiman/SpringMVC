package com.java.web.controller.async;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.context.request.async.WebAsyncTask;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

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

        Callable<String> callable = new Callable<String>() {
            public String call() throws Exception {
                System.out.println("callable");
                Thread.sleep(5000);
                System.out.println("hello callable");
                return "hello async";
            }
        };

        //封装Callable，直接返回WebAsyncTask。就有生命周期方法调用
        WebAsyncTask webAsyncTask = new WebAsyncTask(callable);
        webAsyncTask.onTimeout(() -> {System.out.println("onTimeout");return new Object();});
        webAsyncTask.onCompletion(() -> System.out.println("onCompletion"));

        return callable;
    }

    @RequestMapping(value = "/deferred")
    public DeferredResult<String> deferred(){
        DeferredResult<String> dr = new DeferredResult<String>();
//        dr.onTimeout(() -> System.out.println("onTimeout"));
//        dr.onCompletion(() -> System.out.println("onCompletion"));

        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(()->{
            try {
                System.out.println("deferred");
                Thread.sleep(5000);
                System.out.println("hello deferred");
                dr.setResult("hello deferred");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        return dr;
    }

}
