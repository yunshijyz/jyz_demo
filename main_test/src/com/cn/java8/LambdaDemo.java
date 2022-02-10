package com.cn.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class LambdaDemo {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("www.1","asdcz","dxcsq","d2qda","czxc");

        list.forEach(System.out::println);

    }
}
