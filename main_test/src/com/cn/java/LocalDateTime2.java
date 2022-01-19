package com.cn.java;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

public class LocalDateTime2 {


    public static void main(String[] args) throws ParseException {

//        String queryTime = "2022-01-12 00:00:00";
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date date = simpleDateFormat.parse(queryTime);
//        Instant instant = date.toInstant();

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

//        ZoneId zoneId = ZoneId.systemDefault();
//        LocalDateTime localDateTime = instant.atZone(zoneId).toLocalDateTime();

        String front = "2021-12-20";
        String queryTime = front + " 00:00:00";

        LocalDateTime localDateTime = LocalDateTime.parse(queryTime, dateTimeFormatter);


        //LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime.getYear());
        int value = localDateTime.getDayOfWeek().getValue();
        LocalDateTime monday = localDateTime.with(TemporalAdjusters.previous(DayOfWeek.SUNDAY)).plusDays(1).withHour(0).withMinute(0).withSecond(0);
        LocalDateTime sunday = localDateTime.with(TemporalAdjusters.next(DayOfWeek.MONDAY)).minusDays(1).withHour(23).withMinute(59).withSecond(59);
        System.out.println(value+"--本周一: " + dateTimeFormatter.format(monday));
        System.out.println(value+"--本周日: " + dateTimeFormatter.format(sunday));

    }
}
