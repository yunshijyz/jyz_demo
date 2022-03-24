package com.cn.java;

import java.util.Arrays;
import java.util.List;

public class Test19 {

    public static void main(String[] args) {


        List<String> ips = Arrays.asList("192.168.0.1","192.168.0.6","192.168.0.4","192.168.0.6");
        List<String> sources = Arrays.asList("225.201.21.1","123.023.25.26","123.152.241.12");
//        ips.stream().distinct().collect(Collectors.toList());
        Long ipsCount = ips.stream().distinct().count();
        Long sourcesCount = sources.stream().distinct().count();

        if(ips.size() != ipsCount.intValue()){
            System.out.println("目的ip有重复");
        }
        if(sources.size() != sourcesCount.intValue()){
            System.out.println("源ip有重复，请检查");
        }
    }
}
