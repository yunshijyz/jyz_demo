package com.cn.java;

public class Test10 {


    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        for (int i = 0;i<100000000;i++){
            System.out.println(i);
        }
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }
}
