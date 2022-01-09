package com.example.demo.controller;


import com.example.demo.entity.Demo;
import com.example.demo.entity.NewDemo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class TestController {


    @PostMapping("/test/demo")
    public NewDemo test(@RequestBody Demo demo){
        BigDecimal amount = demo.getAmount().subtract(demo.getNewAmount());
        NewDemo newDemo = new NewDemo();
        newDemo.setAmount(amount);
        String[] strs = demo.getStrs();
        for (String str : strs) {
            System.out.println(str);
        }
        return newDemo;

    }
}
