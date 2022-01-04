package com.example.demo.service;

import com.example.demo.entity.CommodityInfo;



public interface MysqlTestService {

    int insert(CommodityInfo commodityInfo);

    CommodityInfo getInfo(String id);
}
