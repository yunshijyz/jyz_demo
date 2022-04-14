package com.example.demo.service;

import com.example.demo.entity.*;

import java.util.List;
import java.util.Map;

public interface BigDataTestService {
    Map<String,Object> getCount(BigDataVo bigDataVo);

    Map<String,Object> getAllCount();

    List<AlarmTrendTypeCount> alarmTrendCount(StatisticsVo statisticsVo);

    List<WarnMes> selectWarn();
}
