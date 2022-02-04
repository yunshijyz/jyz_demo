package com.cn.java;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class LocalDateTimeTest {

    public static void main(String[] args) {
//        LocalDate d = LocalDate.now(); // 当前日期
//        LocalTime t = LocalTime.now(); // 当前时间
//        LocalDateTime dt = LocalDateTime.now(); // 当前日期和时间
//        System.out.println(d); // 严格按照ISO 8601格式打印
//        System.out.println(t); // 严格按照ISO 8601格式打印
//        System.out.println(dt); // 严格按照ISO 8601格式打印


        LocalDateTime dt = LocalDateTime.now(); // 当前日期和时间
        LocalDate d = dt.toLocalDate(); // 转换到当前日期
        LocalTime t = dt.toLocalTime(); // 转换到当前时间
        System.out.println(d); // 严格按照ISO 8601格式打印
        System.out.println(t); // 严格按照ISO 8601格式打印
        System.out.println(dt); // 严格按照ISO 8601格式打印

        System.out.println("==================================");

        LocalDateTime p = LocalDateTime.parse("2022-01-10T19:53:58.834");
        LocalDate parse = LocalDate.parse("2022-01-10");
        LocalTime parse1 = LocalTime.parse("19:53:58.834");
        System.out.println(p);
        System.out.println(parse);
        System.out.println(parse1);

        System.out.println("----------------------");


        Random random = new Random();

        for (int a = 0;a<100;a++){
            System.out.println(random.nextInt(3)+1);
        }

        System.out.println("----------------------");
        System.out.println("===================================");

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String format = dateTimeFormatter.format(LocalDateTime.now());
        System.out.println(format);

        LocalDateTime parse2 = LocalDateTime.parse("2022-01-10 20:00:10", dateTimeFormatter);
        System.out.println(parse2);

        System.out.println("====================================");
        LocalDateTime of = LocalDateTime.of(2021, 12, 30, 20, 03, 20);
        System.out.println(of);
        String format1 = dateTimeFormatter.format(of);
        System.out.println(format1);
        LocalDateTime localDateTime = of.plusDays(61);
        String format2 = dateTimeFormatter.format(localDateTime);
        System.out.println(format2);
        LocalDateTime localDateTime1 = of.plusMonths(2);
        String format3 = dateTimeFormatter.format(localDateTime1);
        System.out.println(format3);


    }
}
