package com.cn.java;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MapTest {


    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(12,32,43,12,32,43,54,65,12);
        List<String> stringList = Arrays.asList("asd", "DAADS", "ASDsss");



        //list.forEach(System.out::println);
        List<Integer> collect = list.stream().distinct().sorted(Integer::compareTo).collect(Collectors.toList());
        collect.forEach(System.out::println);
        List<String> collect1 = stringList.stream().map(String::toLowerCase).collect(Collectors.toList());
        collect1.forEach(System.out::println);

    }
}
