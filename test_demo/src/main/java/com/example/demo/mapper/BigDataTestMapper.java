package com.example.demo.mapper;

import com.example.demo.entity.BigDataVo;

import java.util.Map;

public interface BigDataTestMapper {

    Map<String,Object> getCount(BigDataVo bigDataVo);

    Map<String, Object> getAllCount();
}
