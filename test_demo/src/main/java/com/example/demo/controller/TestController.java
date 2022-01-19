package com.example.demo.controller;


import cn.hutool.core.util.ObjectUtil;
import com.example.demo.entity.*;
import com.example.demo.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
public class TestController {

    @Autowired
    private TestService testService;

    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");


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


    @PostMapping("/test/rock")
    public String test2(@RequestBody RockBack rockBack){
        System.out.println(rockBack.getStatisticsTime().getCode());
        System.out.println(rockBack.getStatisticsTime().getInfo());
        return "ok";
    }

    @PostMapping("/test/localdate")
    public Void test3(@RequestBody RockBack rockBack){

        WeekRes week = getWeek(rockBack.getDate());
        log.info("monday:{}",week.getMonday());
        log.info("sunday:{}",week.getSunDay());

        return null;
    }

    @PostMapping("/test/map")
    public Void test4(){

        Map<String,ProvinceUseRes> map = new HashMap<>();
        List<Region> list = testService.getList();
        for (Region region : list) {
            ProvinceUseRes res = new ProvinceUseRes();
            res.setProvince(Integer.valueOf(region.getCode()));
            res.setProvinceName(region.getName());
            map.put(region.getCode(),res);
        }

        for (String s : map.keySet()) {
            System.out.println(s+": "+map.get(s));
        }

        return null;
    }


    @GetMapping("insert")
    public String testMybatis(){

        testService.insertList();
        return "ok";
    }

    @PostMapping("province")
    public List<ProvinceRes> testMybatis1(@RequestBody UsageDistributionVo usageDistributionVo){

        List<ProvinceRes> provinceRes = testService.selectProvince(usageDistributionVo);
        log.info("provinceRes:{}",provinceRes);
        return provinceRes;
    }





    private static WeekRes getWeek(String date){
        WeekRes weekRes = new WeekRes();
        LocalDateTime localDateTime = null;
        if(ObjectUtil.isNotEmpty(date)){
            String queryTime = date + " 00:00:00";
            localDateTime = LocalDateTime.parse(queryTime, dateTimeFormatter);
        } else {
            localDateTime = LocalDateTime.now();
        }
        LocalDateTime monday = localDateTime.with(TemporalAdjusters.previous(DayOfWeek.SUNDAY)).plusDays(1).withHour(0).withMinute(0).withSecond(0);
        LocalDateTime sunday = localDateTime.with(TemporalAdjusters.next(DayOfWeek.MONDAY)).minusDays(1).withHour(23).withMinute(59).withSecond(59);
        weekRes.setMonday(dateTimeFormatter.format(monday));
        weekRes.setSunDay(dateTimeFormatter.format(sunday));
        return weekRes;
    }
}
