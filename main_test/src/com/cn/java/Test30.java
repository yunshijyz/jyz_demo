package com.cn.java;

public class Test30 {

    public static void main(String[] args) {
        String x = "u.ser.exe";
        String replace = x.replaceAll("\\.", "");

        System.out.println(x);
        System.out.println(replace);
    }
}
