package com.cn.java;

import org.apache.logging.log4j.util.Strings;

import java.util.Arrays;
import java.util.List;

public class Test14 {


    public static void main(String[] args) {

        String str = "a,b,c";

        List<String> result = Arrays.asList(str.split(","));
        for (String s : result) {
            System.out.println(s);
        }
    }
}
