package com.java.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * URL 模板
 *
 * Created by devin on 2016/12/26.
 */
@Controller
@RequestMapping(value = "/template")
public class URLTemplateController {

    @RequestMapping(value = "/hello/{name}")
    @ResponseBody
    public String hello(@PathVariable(value = "name") String name){
        return String.format("hello %s", name);
    }

    @RequestMapping(value = "/customer/{name}/order/{id}")
    @ResponseBody
    public String multiPathVariable(@PathVariable Map<String, String> vars){
        return String.format("name %s, id %s", vars.get("name"), vars.get("id"));
    }

    @RequestMapping(value = "/regexp/{name:\\w}")
    @ResponseBody
    public String regexp(@PathVariable(value = "name") String name){
        return String.format("hello %s", name);
    }

    @RequestMapping(value = "/ant/*")
    @ResponseBody
    public String ant(){
        return String.format("hello %s", "devin");
    }

    @RequestMapping(value = "/matrix/{pet}", method = RequestMethod.GET)
    @ResponseBody
    public String matrix(@PathVariable String pet, @MatrixVariable String color){
        return String.format("%s is %s", pet, color);
    }

    @RequestMapping(value = "/owners/{ownerId}/pets/{petId}", method = RequestMethod.GET)
    @ResponseBody
    public String findPet(
            @MatrixVariable Map<String, String> matrixVars,
            @MatrixVariable(pathVar="petId") Map<String, String> petMatrixVars) {
        //matrixVars {q=[11, 22], r=[12], s=[23]}
        //petMatrixVars {q=[22], s=[23]}
        return matrixVars.toString()+"  "+petMatrixVars.toString();
    }
}
