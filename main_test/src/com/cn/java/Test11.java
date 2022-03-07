package com.cn.java;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test11 {


    public static void main(String[] args) throws ParseException {
//
//        User user = new User("pool",12);
//        if(user.getAge()!=null && user.getAge().equals("12")){
//            System.out.println("ok");
//        }else {
//            System.out.println("no");
//        }

//
//        Date date = new Date(1646006400000L);
//
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String format = sdf.format(date);
//        System.out.println(format);

       // UTCToCST("2017-11-27T03:16:03.944Z", "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        String s = "2022-02-27T01:00:00.000Z";
        int t = s.indexOf("T");
        int z = s.indexOf("Z");
        System.out.println(t);
        System.out.println(z);
        String ymd = s.substring(0, t);
        System.out.println(ymd);
        System.out.println(t+1);
        System.out.println(z-t-1);
        String hms = s.substring(t + 1, z-4 );
        System.out.println("hms:"+hms);
        String dateTime = ymd+" "+hms;
        System.out.println(dateTime);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date parse = sdf.parse(dateTime);

        long time = parse.getTime();
        long l = time + 8 * 60 * 60 * 1000;
        System.out.println(l);


    }


}
