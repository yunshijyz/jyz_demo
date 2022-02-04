package com.cn.java;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class Test5 {
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    public static void main(String[] args) {

//
//        //1641533100
//        long l = System.currentTimeMillis() ;
//        LocalDate localDate = Instant.ofEpochSecond(1641533100).atZone(ZoneOffset.ofHours(8)).toLocalDate();
//        System.out.println(localDate.toString());

        String format = dateTimeFormatter.format(LocalDateTime.now());
        System.out.println(format);


    }
}
