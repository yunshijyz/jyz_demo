package com.example.demo.entity;

import java.io.Serializable;
import java.util.List;

public class AlarmtrendVo implements Serializable {

    private String day;

    private List<AlarmtrendTrendVo> alarmtrends;


    public void setDay(String day){
        this.day = day;
    }

    public String getDay(){
        return day;
    }

    public void setAlarmtrends(List<AlarmtrendTrendVo> alarmtrends){
        this.alarmtrends = alarmtrends;
    }

    public List<AlarmtrendTrendVo> getAlarmtrends(){
        return alarmtrends;
    }
}
