package com.cn.java;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class TimeTest {

    public static void main(String[] args) {

//        int i = Integer.parseInt(String.valueOf(LocalDateTime.parse("2018-01-11 18:46:40", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")).toEpochSecond(ZoneOffset.of("+8"))));
//        System.out.println(i);
//
//        Float aFloat = new Float(1048576.201);
//        Float v = aFloat / (1048576);
//
//        System.out.println(v);
//
//        LocalDateTime localDateTime = LocalDateTime.now().minusHours(1);
//        System.out.println(localDateTime);

        Long aLong = TimeStampUtil.Yes00();
        Long aLong1 = TimeStampUtil.Yes24();
        System.out.println(aLong);
        System.out.println(aLong1);
    }
}
