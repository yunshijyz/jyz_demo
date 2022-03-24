package com.example.demo.entity;


import java.io.Serializable;

public class AlarmtrendTrendVo implements Serializable {

    private String riskType;

    private Integer count;


    private String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setRiskType(String riskType){
        this.riskType = riskType;
    }

    public String getRiskType(){
        return riskType;
    }


    public void setCount(Integer count){
        this.count = count;
    }

    public Integer getCount(){
        return count;
    }
}
