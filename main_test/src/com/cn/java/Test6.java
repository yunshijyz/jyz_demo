package com.cn.java;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class Test6 {


    private static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");


    public static void main(String[] args) {

        long l = System.currentTimeMillis();


        Long timeStamp = 1641533700L;


       // LocalDateTime.ofEpochSecond()
        String format = dateTimeFormatter.format(LocalDateTime.ofEpochSecond(l /1000, 0, ZoneOffset.ofHours(8)));
        System.out.println(format);
    }
}
