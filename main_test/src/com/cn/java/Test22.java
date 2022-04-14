package com.cn.java;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

public class Test22 {

    public static void main(String[] args) throws ParseException {


        Instant now = Instant.now();




        long l = 1648684200000L;

        Instant instant = Instant.ofEpochMilli(l);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println(dateTimeFormatter.format(instant.atZone(ZoneId.systemDefault())));

        System.out.println(now.toEpochMilli());

        System.out.println(now.minus(6, ChronoUnit.DAYS).toEpochMilli());

        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH)-6,0,0,0);
        System.out.println(calendar.getTimeInMillis());
    }
}
