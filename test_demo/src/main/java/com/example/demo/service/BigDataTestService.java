package com.example.demo.service;

import com.example.demo.entity.AlarmTrendTypeCount;
import com.example.demo.entity.AlarmtrendCount;
import com.example.demo.entity.BigDataVo;
import com.example.demo.entity.StatisticsVo;

import java.util.List;
import java.util.Map;

public interface BigDataTestService {
    Map<String,Object> getCount(BigDataVo bigDataVo);

    Map<String,Object> getAllCount();

    List<AlarmTrendTypeCount> alarmTrendCount(StatisticsVo statisticsVo);
}
