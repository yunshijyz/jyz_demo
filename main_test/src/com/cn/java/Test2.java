package com.cn.java;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test2 {

    public static void main(String[] args) throws ParseException {
        long l = System.currentTimeMillis();
        System.out.println(l);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String format = simpleDateFormat.format(date);
        Date parse = simpleDateFormat.parse("2010-12-01 12:27:22");
        System.out.println("format:"+format);
        long l1 = parse.getTime() / 1000;
        System.out.println(l1);
        System.out.println(parse);
    }
}
