package com.example.demo.entity;


import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class UserExcel {

    @ExcelProperty(index = 0)
    private String name;

    @ExcelProperty(index = 1)
    private Integer age;
}
