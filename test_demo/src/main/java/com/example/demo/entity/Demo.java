package com.example.demo.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Demo {
    
    private BigDecimal amount;

    private BigDecimal newAmount;

    private String[] strs;

}
