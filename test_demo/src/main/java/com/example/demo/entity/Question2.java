package com.example.demo.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class Question2 {

    @ExcelProperty(index = 2)
    private String name;

    @ExcelProperty(value = "检查细项")
    private String text;


}
