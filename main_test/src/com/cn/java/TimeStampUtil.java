package com.cn.java;

import java.util.Calendar;

public class TimeStampUtil {

    public static Long Yes00(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH)-1,0,0,0);
        return calendar.getTimeInMillis();
    }

    public static Long Yes24(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH)-1,23,59,59);
        return calendar.getTimeInMillis();
    }
}
