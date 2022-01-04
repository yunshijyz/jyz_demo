package com.example.demo.controller;



import com.example.demo.entity.CommodityInfo;
import com.example.demo.service.MysqlTestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MysqlTestController {

    private static final Logger log = LoggerFactory.getLogger(MysqlTestController.class);


    @Autowired
    private MysqlTestService mysqlTestService;


    @PostMapping("/insert")
    public int insert(@RequestBody CommodityInfo commodityInfo){

        int insert = mysqlTestService.insert(commodityInfo);
        return insert;
    }

    @GetMapping("/get")
    public CommodityInfo get(String id){
        CommodityInfo info = mysqlTestService.getInfo(id);
        log.info("info:{}",info);
        return info;
    }


}
