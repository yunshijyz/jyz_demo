package com.example.demo.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class Question {


    private String num;

    private String context;

    private Integer type;

    private String detail;

    private String value;

    private String answer;

    private String score;

    private String yesRemake;

    private String noRemake;

    private String remake;


}
