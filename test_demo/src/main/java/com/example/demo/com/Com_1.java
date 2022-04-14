package com.example.demo.com;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;


@Component
@Lazy
public class Com_1 {

    private static final Logger logger = LoggerFactory.getLogger(Com_1.class);

    @Value("${name}")
    private String name;

    @PostConstruct
    public void init() {
        logger.info("init");
    }

    public void work() {
        logger.info(this.getClass().getName() + "do work");
    }


    public static void main(String[] args) {
        Map<String,Integer> map = new TreeMap();
        map.put("2022-03-12 00:12:12",1);
        map.put("2022-03-11 00:12:12",1);
        map.put("2022-03-13 00:12:12",1);
        System.out.println(JSONObject.toJSON(map));

    }

}
