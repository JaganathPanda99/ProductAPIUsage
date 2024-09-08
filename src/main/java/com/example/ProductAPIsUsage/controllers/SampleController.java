package com.example.ProductAPIsUsage.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

    @GetMapping( "/hello" )
    public String helloworld(){
       // GET/hello
        return "Hello World";
    }

    //GET /helloWithName{name}
    @GetMapping(   "/hello/{name}")
    public String helloWithName(@PathVariable("name") String name ){
        return "Hello " + name;
    }

     //GET /Name/{name}/UID/{UID}
    @GetMapping( "/name/{name}/UID/{UID}")
    public String helloMultiple(@PathVariable("name") String name , @PathVariable("UID") String UID  ){
        return "Hello " + name + " " + UID;
    }




}
