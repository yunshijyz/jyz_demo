package com.example.demo.test;


import com.example.demo.entity.UserAnalysisVo;
import com.example.demo.entity.enums.StatisticsTimeEnum;
import com.example.demo.utils.GetTimeUtil;



public class Test5 {

    public static void main(String[] args) {

        UserAnalysisVo time = GetTimeUtil.getTime(StatisticsTimeEnum.YEAR);
        System.out.println(time.getEndTime());
        System.out.println(time.getStartTime());
    }
}
