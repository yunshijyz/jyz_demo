package com.cn.java;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.Random;

public class Test4 {



    public static void main(String[] args) {
        //System.out.println(LocalDateTime.now().minusDays(6).toInstant(ZoneOffset.of("+8")).toEpochMilli());
        System.out.println(LocalDate.now().minusDays(6).atTime(00, 00, 00).toInstant(ZoneOffset.of("+8")).toEpochMilli());
        System.out.println(LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli());
        long time = System.currentTimeMillis();
        System.out.println(time);
    }
}
