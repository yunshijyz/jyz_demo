package com.example.demo.com;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Com_2 {

    private static final Logger logger = LoggerFactory.getLogger(Com_2.class);

    @Autowired
    private Com_1 com_1;

    @PostConstruct
    public void init() {
        logger.info("init");
    }

    public void work() {
        logger.info(this.getClass().getName() + "do work");
    }
}