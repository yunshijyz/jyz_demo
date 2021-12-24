package com.example.security.controller;



import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @GetMapping
    @PreAuthorize("hasRole('def')")
    public String helloAdmin(){
        return "hello admin";
    }


    @GetMapping("/hello")
    @PreAuthorize("hasRole('abc')")
    public String helloAdmin2(){
        return "hello admin:abc";
    }

}
