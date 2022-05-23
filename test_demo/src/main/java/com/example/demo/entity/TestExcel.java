package com.example.demo.entity;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @Description:
 * @Author：chenyanbin
 * @CreateTime: 2022-02-16 13:50
 * @Version：1.0.0
 */
@Data
public class TestExcel {
    @ExcelProperty(value="姓名",index = 0)
    private String name;

    @ExcelProperty(value="年龄",index = 1)
    private String age;

    @ExcelProperty(value="合并测试",index = 2)
    private String test;
}