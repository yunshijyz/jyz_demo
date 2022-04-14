package com.example.demo.com;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext appc = new AnnotationConfigApplicationContext("com.example.demo.com");
        Com_1 com_1 = appc.getBean(Com_1.class);
    }
}
