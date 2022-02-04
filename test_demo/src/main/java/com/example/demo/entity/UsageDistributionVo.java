package com.example.demo.entity;


import lombok.Data;

import java.util.List;

@Data
public class UsageDistributionVo {

    private String startTime;

    private String endTime;

    private List<String> domains;
}
