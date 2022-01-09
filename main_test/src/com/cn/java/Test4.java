package com.cn.java;

public class Test4 {

    public static void main(String[] args) {
        String[] strs = new String[4];
        strs[0] = "stor";
        strs[1] = "hello";
        strs[2] = "uhj";
        strs[3] = "ndaz";
        System.out.println(strs);

        for (String str : strs) {
            System.out.println(str);
        }
    }
}
