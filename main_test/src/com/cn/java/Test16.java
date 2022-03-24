package com.cn.java;

import java.util.Arrays;
import java.util.List;

public class Test16 {


    public static void main(String[] args) {
        List<String> cities = Arrays.asList("Milan",
                "London",
                "New York",
                "San Francisco");
        String citiesCommaSeparated = String.join(",", cities);
        System.out.println(citiesCommaSeparated);
    }
}
