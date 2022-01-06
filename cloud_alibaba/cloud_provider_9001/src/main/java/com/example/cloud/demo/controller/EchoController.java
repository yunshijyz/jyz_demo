package com.example.cloud.demo.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EchoController {


    @GetMapping("/echo/{string}")
    public String echo(@PathVariable String string){
        return "Hello Nacos Discovery:" + string;
    }


}
