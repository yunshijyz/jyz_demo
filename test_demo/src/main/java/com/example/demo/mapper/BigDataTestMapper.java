package com.example.demo.mapper;

import com.example.demo.entity.AlarmtrendTrendVo;
import com.example.demo.entity.BigDataVo;
import com.example.demo.entity.StatisticsVo;
import com.example.demo.entity.WarnMes;

import java.util.List;
import java.util.Map;

public interface BigDataTestMapper {

    Map<String,Object> getCount(BigDataVo bigDataVo);

    Map<String, Object> getAllCount();

    List<AlarmtrendTrendVo> alarmTrendCount(StatisticsVo statisticsVo);

    List<String> selectType();

    List<WarnMes> selectWarn();
}
