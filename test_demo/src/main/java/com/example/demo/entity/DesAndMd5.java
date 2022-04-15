package com.example.demo.entity;


import lombok.Data;

@Data
public class DesAndMd5 {


    private String des;

    private String base64;

    private String key1;

    private String key2;

    private String md5one;

    private String finalMd5;

    private boolean result;
}
