package com.example.demo.utils;

import com.example.demo.entity.UserAnalysisVo;
import com.example.demo.entity.enums.StatisticsTimeEnum;


import java.time.format.DateTimeFormatter;

public class GetTimeUtil {

    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static UserAnalysisVo getTime(StatisticsTimeEnum statisticsTimeEnum){


        UserAnalysisVo userAnalysisVo = new UserAnalysisVo();

        if(StatisticsTimeEnum.MONTH.equals(statisticsTimeEnum)){

            userAnalysisVo.setStartTime(dateTimeFormatter.format(LocalDateTimeUtils.monthStartTime()));
            userAnalysisVo.setEndTime(dateTimeFormatter.format(LocalDateTimeUtils.monthEndTime()));

        } else if(StatisticsTimeEnum.YEAR.equals(statisticsTimeEnum)){

            userAnalysisVo.setStartTime(dateTimeFormatter.format(LocalDateTimeUtils.yearStartTime()));
            userAnalysisVo.setEndTime(dateTimeFormatter.format(LocalDateTimeUtils.yearEndTime()));

        } else if (StatisticsTimeEnum.SEASON.equals(statisticsTimeEnum)){
            userAnalysisVo.setStartTime(dateTimeFormatter.format(LocalDateTimeUtils.quarterStartTime()));
            userAnalysisVo.setEndTime(dateTimeFormatter.format(LocalDateTimeUtils.quarterEndTime()));

        } else if(StatisticsTimeEnum.WEEK.equals(statisticsTimeEnum)){
            userAnalysisVo.setStartTime(dateTimeFormatter.format(LocalDateTimeUtils.weekStartTime()));
            userAnalysisVo.setEndTime(dateTimeFormatter.format(LocalDateTimeUtils.weekEndTime()));

        }

        return userAnalysisVo;

    }
}
