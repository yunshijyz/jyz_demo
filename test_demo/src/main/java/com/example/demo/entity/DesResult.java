package com.example.demo.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class DesResult implements Serializable {

    private String des;

    private String base64;
}
