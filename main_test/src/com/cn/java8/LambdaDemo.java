package com.cn.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class LambdaDemo {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("www.1","asdcz","dxcsq","d2qda","czxc");

        Stream<String> stream = Stream.of("ab", "abc", "abcd", "abcde", "abcdef");

        Stream<Integer> stream2 = Stream.iterate(0, (x) -> x + 3).limit(5);
        stream2.forEach(r -> System.out.print(r + " "));

        System.out.println();

        Stream<Integer> stream3 = Stream.generate(new Random()::nextInt).limit(3);
        stream3.forEach(r -> System.out.print(r + " "));

        //list.forEach(System.out::println);

        int[] ints = list.stream().mapToInt(x -> x.length()).toArray();

        System.out.println("ints:"+Arrays.toString(ints));






        List<Integer> list1 = new ArrayList<>();

    }
}
