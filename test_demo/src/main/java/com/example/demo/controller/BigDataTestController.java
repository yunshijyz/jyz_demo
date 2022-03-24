package com.example.demo.controller;









import com.alibaba.fastjson.JSON;
import com.example.demo.entity.*;
import com.example.demo.service.BigDataTestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/bigdata")
@RequiredArgsConstructor
@Slf4j
public class BigDataTestController {

    private final BigDataTestService bigDataTestService;


    @GetMapping("/test1")
    public String bigdataTest(BigDataVo bigDataVo){

        Map<String, Object> count = bigDataTestService.getCount(bigDataVo);
        //Map<String, Object> allCount = bigDataTestService.getAllCount();
        log.info("mapByIp:{}",count);
        //log.info("mapAllIp:{}",allCount);

        return "success";

    }


    @PostMapping("/count")
    public List<AlarmTrendTypeCount> bigdataTestCount(@RequestBody StatisticsVo statisticsVo){


        List<AlarmTrendTypeCount> alarmTrendTypeCounts = bigDataTestService.alarmTrendCount(statisticsVo);

        return alarmTrendTypeCounts;

    }
    @GetMapping("/test12")
    public String test(){

        List<ImpelementTime> times = new ArrayList<>();
        ImpelementTime impelementTime = new ImpelementTime();
        impelementTime.setStartTime("2022-01-12 12:55:12");
        impelementTime.setEndTime("2022-01-19 12:55:12");
        ImpelementTime impelementTime2 = new ImpelementTime();
        impelementTime2.setStartTime("2022-02-24 00:00:00");
        impelementTime2.setEndTime("2022-03-24 23:59:59");
        ImpelementTime impelementTime3 = new ImpelementTime();
        impelementTime3.setStartTime("2022-03-12 00:00:00");
        impelementTime3.setEndTime("2022-04-23 23:59:59");
        times.add(impelementTime);
        times.add(impelementTime2);
        times.add(impelementTime3);
        String s1 = JSON.toJSONString(times);
        System.out.println(s1);

        List<ImpelementTime> impelementTimes = JSON.parseArray(s1, ImpelementTime.class);
        for (ImpelementTime time : impelementTimes) {
            System.out.println(time);
        }


        List<String> strings = Arrays.asList("192.168.0.1", "192.63.25.1", "195.12.41.41");
        String s = strings.toString();
        System.out.println(s);
        return "sucess";
    }
}
