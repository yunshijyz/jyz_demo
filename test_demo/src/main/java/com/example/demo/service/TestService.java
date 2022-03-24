package com.example.demo.service;

import com.example.demo.entity.OverviewPermissions;
import com.example.demo.entity.ProvinceRes;
import com.example.demo.entity.Region;
import com.example.demo.entity.UsageDistributionVo;

import java.util.List;

public interface TestService {
    List<Region> getList();

    void insertList();

    List<ProvinceRes> selectProvince(UsageDistributionVo usageDistributionVo);

    List<OverviewPermissions> selectTree();

    List<OverviewPermissions> getMenu();
}
