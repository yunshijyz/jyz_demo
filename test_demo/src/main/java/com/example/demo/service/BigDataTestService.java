package com.example.demo.service;

import com.example.demo.entity.BigDataVo;

import java.util.Map;

public interface BigDataTestService {
    Map<String,Object> getCount(BigDataVo bigDataVo);

    Map<String,Object> getAllCount();
}
