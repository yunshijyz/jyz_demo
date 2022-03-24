package com.cn.java;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class Test15 {

    public static void main(String[] args) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        String endTime = LocalDate.now().format(dateFormatter)+" 23:59:59";
        String startTime = LocalDate.now().minusDays(31).format(dateFormatter)+" 00:00:00";
        System.out.println(startTime);
        System.out.println(endTime);
    }
}
