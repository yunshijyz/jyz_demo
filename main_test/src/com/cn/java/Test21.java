package com.cn.java;

import java.text.DateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class Test21 {

    public static void main(String[] args) {
        Instant now = Instant.now();
        now.plus(4,ChronoUnit.DAYS);
        long l = Instant.now().toEpochMilli();
        long l1 = System.currentTimeMillis();
        System.out.println(l);
        System.out.println(l1);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        Instant instant = Instant.ofEpochMilli(System.currentTimeMillis());

        Instant plus = instant.plus(5, ChronoUnit.DAYS);
        System.out.println(plus.atZone(ZoneId.systemDefault()).format(dateTimeFormatter));

        System.out.println(instant);
        Instant instant_3 = instant.plusSeconds(60 * 60 * 24 * 3);
        ZonedDateTime shanghai = instant.atZone(ZoneId.systemDefault());
        ZonedDateTime shanghai__3 = instant_3.atZone(ZoneId.of("Asia/Shanghai"));
        ZonedDateTime shanghai_3 = shanghai.minusDays(3);
        ZonedDateTime Los_Angeles = instant.atZone(ZoneId.of("America/Los_Angeles"));
        String format = shanghai.format(dateTimeFormatter);
        System.out.println(format);
        System.out.println(shanghai);
        System.out.println(shanghai_3);
        System.out.println(shanghai__3);
        System.out.println(Los_Angeles);


    }
}
