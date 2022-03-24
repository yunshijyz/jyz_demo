package com.cn.java;

import java.util.Arrays;
import java.util.List;

public class Test18 {

    public static void main(String[] args) {
      String s = "192.168.0.1-192.168.0.123";
      if(s.contains("-")){
          String[] split = s.split("-");
          String start = split[0];
          String end = split[1];
          System.out.println(start);
          System.out.println(end);
          System.out.println(true);
      }

    }
}
