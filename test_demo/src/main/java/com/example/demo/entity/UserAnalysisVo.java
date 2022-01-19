package com.example.demo.entity;


import com.example.demo.entity.enums.StatisticsTimeEnum;

import lombok.Data;

@Data
public class UserAnalysisVo {


    private String regionCode;

    private String channelSource;

    private Integer manufacturerId;

    private String startTime;

    private String endTime;

    private StatisticsTimeEnum statisticsTimeEnum;



}
