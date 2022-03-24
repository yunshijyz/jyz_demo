package com.example.demo.entity;

import lombok.Data;
import org.omg.CORBA.PRIVATE_MEMBER;

import java.util.List;

@Data
public class AlarmTrendTypeCount {

    private String type;

    private List<AlarmTrendDateCount> countList;
}
