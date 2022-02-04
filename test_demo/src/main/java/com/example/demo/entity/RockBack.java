package com.example.demo.entity;


import com.example.demo.entity.enums.OrderStatusEnum;
import com.example.demo.entity.enums.OrderTypeEnum;
import com.example.demo.entity.enums.StatisticsTimeEnum;
import lombok.Data;

@Data
public class RockBack {

    private Integer id;

    private String name;

    private OrderTypeEnum orderType;

    private OrderStatusEnum orderStatus;

    private StatisticsTimeEnum statisticsTime;

    private String date;



}
