package com.example.demo.com;

import lombok.Data;

import java.util.List;

@Data
public class User {

    private String name;

    private Integer id;

    private List<Integer> arr;
}
