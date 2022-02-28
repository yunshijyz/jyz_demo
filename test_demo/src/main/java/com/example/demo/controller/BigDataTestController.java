package com.example.demo.controller;


import com.example.demo.entity.BigDataVo;
import com.example.demo.service.BigDataTestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

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
}
