package com.cn.java;

import java.util.Calendar;

public class Test13 {

    public static void main(String[] args) {

        System.out.println(getYesterdayStart());
        System.out.println(getYesterdayEnd());

    }



    /**
     * 获取昨日的开始时间戳
     * @return
     */
    public static Long getYesterdayStart(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH)-1,0,0,0);
        return calendar.getTimeInMillis();
    }

    /**
     * 获取昨日的结束时间戳
     * @return
     */
    public static Long getYesterdayEnd(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH)-1,23,59,59);
        return calendar.getTimeInMillis();
    }
}
