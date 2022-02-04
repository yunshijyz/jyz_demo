package com.example.demo.entity.enums;

import lombok.Getter;

@Getter
public enum StatisticsTimeEnum {

    YEAR(1,"年"),
    SEASON(2,"季"),
    MONTH(3,"月"),
    WEEK(4,"周"),
    TOTAL(5,"累计")

    ;

    private int code;

    private String info;

    StatisticsTimeEnum(int code, String info){
        this.code = code;
        this.info = info;
    }

}
