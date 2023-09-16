package com.shaheer.udemy.springbootrestapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController   // this annotation adds Controller and ResponseBody annotation. ResponseBody converts the output object into JSON
public class HelloWorldController {

    @GetMapping("/hello-world")
    public String helloWorld(){

        StringBuilder sb = new StringBuilder();
        if(!sb.toString().isEmpty() && sb.toString() != null){

            return "this check has failed";
        }else{
            return "Hello World";
        }

      //  return "Hello World!"; // ResponseBody won't convert it to JSON coz it only converts non-String objects
    }
}
