package com.example.demo.service.impl;

import com.example.demo.entity.CommodityInfo;
import com.example.demo.mapper.MysqlTestMapper;
import com.example.demo.service.MysqlTestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MysqlTestServiceImpl implements MysqlTestService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MysqlTestMapper mysqlTestMapper;

    @Override
    public int insert(CommodityInfo commodityInfo) {

//        log.info("commodityInfo:{}",commodityInfo);
        return mysqlTestMapper.insert(commodityInfo);
    }

    @Override
    public CommodityInfo getInfo(String id) {
        log.info("id:{}",id);
        return mysqlTestMapper.selectByPrimaryKey(id);
    }
}
