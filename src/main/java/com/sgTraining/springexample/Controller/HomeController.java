package com.sgTraining.springexample.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//Creating Controller class to manage Rest API

//Rest API annotation
@RestController
public class HomeController {

	//Using Get Mapping with path
    @GetMapping(value = "/home")
    public String helloWorld(){
//        System.out.println("Hello World");
        return "Hello World2!";
    }

}
