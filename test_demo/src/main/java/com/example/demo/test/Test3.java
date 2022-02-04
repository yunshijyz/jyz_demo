package com.example.demo.test;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import org.springframework.util.StringUtils;

public class Test3 {

    public static void main(String[] args) {

        boolean empty = ObjectUtil.isEmpty("");
        boolean empty1 = ObjectUtil.isEmpty(" ");
        boolean aNull = ObjectUtil.isNull("");
        boolean aNull1 = ObjectUtil.isNull(" ");
        boolean notEmpty = ObjectUtil.isNotEmpty("");
        boolean notEmpty1 = ObjectUtil.isNotNull("");
        System.out.println(empty);
        System.out.println(empty1);
        System.out.println(aNull);
        System.out.println(aNull1);
        System.out.println(notEmpty);
        System.out.println(notEmpty1);
    }
}
