package com.cn.java;

import java.util.Arrays;
import java.util.List;

public class Test23 {


    public static void main(String[] args) {

        String s = "classification:overview";

        List<String> strings = Arrays.asList(s.split(","));
        for (String string : strings) {
            System.out.println(string);
        }
    }
}
