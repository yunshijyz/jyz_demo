package com.example.demo.entity;

import java.io.Serializable;
import java.util.List;

public class StatisticsVo implements Serializable {

    private List<String> ips;

    private Integer adminid;

    private String createStartTime;

    private String createEndTime;

    private Long rangeValueEnd;

    private Long rangeValueStart;


    public void setRangeValueStart(Long rangeValueStart){
        this.rangeValueStart = rangeValueStart;
    }

    public Long getRangeValueStart(){
        return rangeValueStart;
    }

    public void setRangeValueEnd(Long rangeValueEnd){
        this.rangeValueEnd = rangeValueEnd;
    }

    public Long getRangeValueEnd(){
        return rangeValueEnd;
    }

    public void setCreateStartTime(String createStartTime){
        this.createStartTime = createStartTime;
    }

    public String getCreateEndTime(){
        return createEndTime;
    }

    public void setCreateEndTime(String createEndTime){
        this.createEndTime = createEndTime;
    }

    public String getCreateStartTime(){
        return createStartTime;
    }

    public void setAdminid(Integer adminid){
        this.adminid = adminid;
    }

    public Integer getAdminid(){
        return adminid;
    }

    public void setIps(List<String> ips){
        this.ips = ips;
    }

    public List<String> getIps(){
        return ips;
    }
}
