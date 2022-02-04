package com.cn.java;

import java.util.Random;

public class Test4 {



    public static void main(String[] args) {
        String[] str = {
                "静态加速",
                "视频加速",
                "所有加速"
        };

        Random random = new Random();
        for(int i = 0;i<10;i++){

            System.out.println(str[random.nextInt(3)]);
            System.out.println(str[random.nextInt(3)]);
            System.out.println(str[random.nextInt(3)]);
        }

    }
}
