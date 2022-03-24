package com.example.demo.entity;

import java.io.Serializable;
import java.util.List;

public class AlarmtrendCount implements Serializable {

    private Integer totalCount;

    private List<AlarmtrendTrendVo> biscuits;

    private List<AlarmtrendVo> alarmtrendVoList;

    public void setTotalCount(Integer totalCount){
        this.totalCount = totalCount;
    }

    public Integer getTotalCount(){
        return totalCount;
    }

    public void setBiscuits(List<AlarmtrendTrendVo> biscuits){
        this.biscuits = biscuits;
    }

    public List<AlarmtrendTrendVo> getBiscuits(){
        return biscuits;
    }

    public void setAlarmtrendVoList(List<AlarmtrendVo> alarmtrendVoList){
        this.alarmtrendVoList = alarmtrendVoList;
    }

    public List<AlarmtrendVo> getAlarmtrendVoList(){
        return alarmtrendVoList;
    }
}
