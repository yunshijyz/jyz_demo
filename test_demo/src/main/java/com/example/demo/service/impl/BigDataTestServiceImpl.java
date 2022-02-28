package com.example.demo.service.impl;

import com.example.demo.entity.BigDataVo;
import com.example.demo.mapper.BigDataTestMapper;
import com.example.demo.service.BigDataTestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
@RequiredArgsConstructor
public class BigDataTestServiceImpl implements BigDataTestService {

    private final BigDataTestMapper bigDataTestMapper;

    @Override
    public Map<String,Object> getCount(BigDataVo bigDataVo) {
        Boolean b = true;
        if(b){
            bigDataVo.setIps(null);
        }
        return bigDataTestMapper.getCount(bigDataVo);
    }

    @Override
    public Map<String, Object> getAllCount() {
        return bigDataTestMapper.getAllCount();
    }
}
