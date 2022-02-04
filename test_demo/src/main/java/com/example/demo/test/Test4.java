package com.example.demo.test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class Test4 {

    public static void main(String[] args) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
       // LocalDate now = LocalDate.now();
        LocalDate now = LocalDate.of(2021, 3, 23);
        Month start = Month.of(now.getMonth().firstMonthOfQuarter().getValue());
        LocalDateTime of = LocalDateTime.of(LocalDate.of(now.getYear(), start, 1), LocalTime.MIN);
        System.out.println(dateTimeFormatter.format(of));

        Month end = Month.of(now.getMonth().firstMonthOfQuarter().getValue()).plus(2L);
        LocalDateTime of1 = LocalDateTime.of(LocalDate.of(now.getYear(), end, end.length(now.isLeapYear())), LocalTime.MAX);
        System.out.println(dateTimeFormatter.format(of1));


    }
}
