package com.cn.java;

import java.util.Arrays;
import java.util.List;

public class Test20 {

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("192.168.0.1", "192.63.25.1", "195.12.41.41","sd","wq","gf");
//        String s = strings.toString();
//        System.out.println(s);

        boolean test = test(strings);
        System.out.println(test);

        System.out.println(testSwitch(2));


    }


    public static boolean test(List<String> list){
        Integer count = 0;
        for(int i =0;i<list.size();i++){
            System.out.println(list.get(i));
            count += 1;
            if(count > 6){
                return false;
            }

        }

        return true;
    }


    public static String testSwitch(Integer code){

        String s = "";

        switch (code){
            case 1:
               s = "1";
               break;
            case 2:
               s = "2";
               break;
            case 3:
               s = "3";
               break;
            default:
                s = "null";
        }

        return s;

    }
}
