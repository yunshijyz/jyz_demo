package com.cn.java;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Test5 {

    public static void main(String[] args) {

        //LocalDate beginDateTime = LocalDate.parse(beginDate, DateTimeFormatter.ofPattern(“yyyy-MM-dd”));
        //LocalDateTime now = LocalDateTime.now();
        LocalDateTime of = LocalDateTime.of(2021, 12, 05, 12, 12, 12);

        String startTime = "2021-12-09 00:00:00";
        String endTime = "2022-01-08 23:59:59";




        LocalDateTime startDate= LocalDateTime.parse(startTime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        LocalDateTime nowDate= LocalDateTime.parse(endTime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        Duration between = Duration.between(startDate,nowDate );
        long l = between.toDays();

        if(l > 30){
            System.out.println("起止时间不能超过31天，请检查时间参数");
        } else if (l < 0){
            System.out.println("时间参数设置有误，请检查");
        }
//        int count = 0;
//        while (l>30){
//            //服务
//            LocalDateTime localDateTime = startDate.plusDays(30);
//            System.out.println("时间:"+DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(localDateTime));
//
//
//            System.out.println();
//            l=l - 30;
//            count += 1;
//        }
//
//        if(l > 0){
//
//        }
//
//
//        System.out.println(count);
//        System.out.println(l);
        System.out.println(l);


    }
}
