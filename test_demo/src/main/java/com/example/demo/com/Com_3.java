package com.example.demo.com;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;

public class Com_3 {

    private static final Logger logger = LoggerFactory.getLogger(Com_3.class);

    @Value("${name}")
    private String name;

    @PostConstruct
    public void init() {
        logger.info("init");
    }

    public void work() {
        logger.info(this.getClass().getName() + "do work");
    }
}