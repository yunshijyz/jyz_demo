package com.cn.java;

import java.util.Arrays;
import java.util.List;

public class Test6 {


    public static void main(String[] args) {

         List<String> domains = Arrays.asList(
                "testcdn1.supertcn.com",
                "testcdn4.supertcn.com",
                "testcdn5.supertcn.com",
                "testcdn6.supertcn.com",
                "testcdn3.supertcn.com",
                "testcdn.supertcn.com",
                "testcdn12.supertcn.com",
                "testcdn13.supertcn.com",
                "testcdn14.supertcn.com");

        StringBuilder domainStr = new StringBuilder();

        for(int i =0;i<domains.size();i++){
            if(i == domains.size()-1){
                domainStr.append(domains.get(i));
            }else {
                domainStr.append(domains.get(i));
                domainStr.append("|");
            }
        }

        System.out.println(domainStr);
    }
}
