package com.example.demo.mapper;

import com.example.demo.entity.*;

import java.util.List;

public interface TestMapper {
    List<Region> getList();

    void insertList(List<ProvinceBandwidth> list);

    List<ProvinceRes> selectProvince(UsageDistributionVo usageDistributionVo);

    List<OverviewPermissions> selectTree();
}
