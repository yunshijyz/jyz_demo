package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.mapper.BigDataTestMapper;
import com.example.demo.service.BigDataTestService;
import com.example.demo.utils.GetTimeUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;


@Service
@RequiredArgsConstructor
@Slf4j
public class BigDataTestServiceImpl implements BigDataTestService {

    private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

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

    @Override
    public List<AlarmTrendTypeCount> alarmTrendCount(StatisticsVo statisticsVo) {
        if(statisticsVo.getAdminid() != null && statisticsVo.getAdminid().equals(1)){
            statisticsVo.setIps(null);
        }
        if(statisticsVo.getRangeValueStart() != null && statisticsVo.getRangeValueEnd() != null) {
            Date start = new Date(statisticsVo.getRangeValueStart());
            Date end = new Date(statisticsVo.getRangeValueEnd());
            statisticsVo.setCreateStartTime(sdf.format(start));
            statisticsVo.setCreateEndTime(sdf.format(end));
        }

        //获取近7天日期
        List<String> datesBetweenUsingJava8 = GetTimeUtil.getDatesBetweenUsingJava8(LocalDate.now().minusDays(6), LocalDate.now().plusDays(1));


        Map<String, AlarmTrendTypeCount> map = new HashMap<>();
        //获取有多少种类型
        List<String> strings = bigDataTestMapper.selectType();
        for (String type : strings) {
            AlarmTrendTypeCount resultRes = new AlarmTrendTypeCount();
            resultRes.setType(type);
            List<AlarmTrendDateCount> r = new ArrayList<>(datesBetweenUsingJava8.size());
            for (String betweenDate : datesBetweenUsingJava8) {
                AlarmTrendDateCount resultRecord = new AlarmTrendDateCount();
                resultRecord.setDate(betweenDate);
                resultRecord.setCount(0);
                r.add(resultRecord);
            }
            resultRes.setCountList(r);
            map.put(type,resultRes);
        }

        //获取日期加类型数量
        List<AlarmtrendTrendVo> alarmtrendTrendVos = bigDataTestMapper.alarmTrendCount(statisticsVo);

        for (AlarmtrendTrendVo alarmtrendTrendVo : alarmtrendTrendVos) {
            String key = alarmtrendTrendVo.getRiskType();

            if(map.containsKey(key)){
                AlarmTrendTypeCount alarmTrendTypeCount = map.get(key);
                List<AlarmTrendDateCount> countList = alarmTrendTypeCount.getCountList();
                for (AlarmTrendDateCount count : countList) {
                    if(alarmtrendTrendVo.getDate().equals(count.getDate())){
                        count.setCount(count.getCount()+alarmtrendTrendVo.getCount());
                    }
                }
                continue;
            }
        }
        List<AlarmTrendTypeCount> list =new ArrayList<>();
        for (Map.Entry<String,AlarmTrendTypeCount> map1:map.entrySet()){
            list.add(map1.getValue());
        }
        return list;

    }
}
