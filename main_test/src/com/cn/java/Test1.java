package com.cn.java;

import java.math.BigDecimal;

public class Test1 {

    public static void main(String[] args) {



        BigDecimal bigDecimal = new BigDecimal("1000.2");
        BigDecimal newDecimal = new BigDecimal("2000.4");
        BigDecimal newDecimal1 = new BigDecimal("800.4");
        System.out.println(bigDecimal.subtract(newDecimal));
        System.out.println(bigDecimal.subtract(newDecimal1));
    }
}
