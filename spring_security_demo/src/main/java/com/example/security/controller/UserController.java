package com.example.security.controller;



import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class UserController {


    @RequestMapping("/main")
    @PreAuthorize("hasRole('abc')")
    public String main(){

        return "redirect:main.html";
    }

    @RequestMapping("/hasAdmin")
    public String main1(){

        return "redirect:main.html";
    }


    @RequestMapping("/main2")
    public String main2(){

        return "redirect:main.html";
    }


}
