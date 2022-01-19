package com.example.demo.mapper;

import com.example.demo.entity.ProvinceBandwidth;
import com.example.demo.entity.ProvinceRes;
import com.example.demo.entity.Region;
import com.example.demo.entity.UsageDistributionVo;

import java.util.List;

public interface TestMapper {
    List<Region> getList();

    void insertList(List<ProvinceBandwidth> list);

    List<ProvinceRes> selectProvince(UsageDistributionVo usageDistributionVo);
}
