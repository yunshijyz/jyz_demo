package com.example.demo.test;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;

public class SnoTest {

    public static void main(String[] args) {

        Snowflake snowflake = IdUtil.getSnowflake();
        System.out.println(snowflake.nextId());
    }
}
