package com.java.web.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;

import static org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder.on;

/**
 * URIComponets 使用
 * Created by devin on 2016/12/29.
 */
@Controller
@RequestMapping(value = "/uri")
public class URIComponentsController {

    @RequestMapping(value = "/user/{name}")
    public ResponseEntity<String> uri(HttpServletRequest req, @PathVariable String name, @RequestParam int id) {

        UriComponents uriComponents = null;

        uriComponents = UriComponentsBuilder.fromUriString(
                "http://example.com/hotels/{hotel}/bookings/{booking}").build();
        URI uri = uriComponents.expand("42", "21").encode().toUri();
        System.out.println(uri.toString());

        uriComponents = UriComponentsBuilder.newInstance()
                .scheme("http").host("example.com").path("/hotels/{hotel}/bookings/{booking}").build()
                .expand("42", "21")
                .encode();
        System.out.println(uriComponents.toUri().toString());

        //重用 host, scheme, port, path 和 query
        uriComponents = ServletUriComponentsBuilder.fromRequest(req)
                .replaceQueryParam("id", "{id}")//替换id参数，没有添加上
                .build()
                .expand("1")
                .encode();
        System.out.println(uriComponents.toUri().toString());

        //// 重用 host，port
        uriComponents = ServletUriComponentsBuilder.fromContextPath(req)
                .path("/accounts")// 用/accouts替换换来的path部分
                .build();
        System.out.println(uriComponents.toUri().toString());

        uriComponents = ServletUriComponentsBuilder.fromServletMapping(req)
                .path("/accounts")//用/accouts替换换来的path部分
                .build();
        System.out.println(uriComponents.toUri().toString());


        uriComponents = MvcUriComponentsBuilder
                .fromMethodName(URIComponentsController.class, "uri", null, "devin", 21).build();
        System.out.println(uriComponents.toUri().toString());

        uriComponents = MvcUriComponentsBuilder
                .fromMethodCall(on(URIComponentsController.class).uri(null, "devin", 21)).build();
        System.out.println(uriComponents.toUri().toString());

        return null;
    }

    @RequestMapping(value = "/home")
    @ResponseBody
    public String home(){
        return "hello world";
    }

    @RequestMapping(value = "/index")
    public String index(){
        return "mvc_url";
    }

}
