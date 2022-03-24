package com.example.demo.mapper;

import com.example.demo.entity.AlarmtrendTrendVo;
import com.example.demo.entity.BigDataVo;
import com.example.demo.entity.StatisticsVo;

import java.util.List;
import java.util.Map;

public interface BigDataTestMapper {

    Map<String,Object> getCount(BigDataVo bigDataVo);

    Map<String, Object> getAllCount();

    List<AlarmtrendTrendVo> alarmTrendCount(StatisticsVo statisticsVo);

    List<String> selectType();
}
