package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.mapper.TestMapper;
import com.example.demo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestMapper testMapper;


    @Override
    public List<Region> getList() {
        return testMapper.getList();
    }

    @Override
    public void insertList() {

        List<ProvinceBandwidth> list = new ArrayList<>();

        for (int i =0;i<30;i++){
            ProvinceBandwidth province = new ProvinceBandwidth();
            province.setProvince(1000+i);
            province.setBandwidth(10*i);
            province.setIspCode(10+i);
            province.setStartTime(LocalDateTime.now());
            province.setStartTime(LocalDateTime.now());
            province.setDomain("www.test"+i+".com");
            province.setFlow(0);
            list.add(province);
        }

        testMapper.insertList(list);
    }

    @Override
    public List<ProvinceRes> selectProvince(UsageDistributionVo usageDistributionVo) {
        return testMapper.selectProvince(usageDistributionVo);
    }

    @Override
    public List<OverviewPermissions> selectTree() {
        return testMapper.selectTree();
    }

    @Override
    public List<OverviewPermissions> getMenu() {
        return testMapper.selectTree();
    }
}
