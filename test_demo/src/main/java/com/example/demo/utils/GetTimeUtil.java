package com.example.demo.utils;

import cn.hutool.json.JSONUtil;
import com.example.demo.entity.ProvinceRes;
import com.example.demo.entity.UserAnalysisVo;
import com.example.demo.entity.enums.StatisticsTimeEnum;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GetTimeUtil {

    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        ProvinceRes provinceRes = new ProvinceRes();
        provinceRes.setProvince(123);
        provinceRes.setBandwidth(1333);
        provinceRes.setPName("province");
        provinceRes.setFlow(456);
        String s = objectMapper.writeValueAsString(provinceRes);
        String s1 = JSONUtil.toJsonStr(provinceRes);
        System.out.println(s);
        System.out.println(s1);

    }

    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static UserAnalysisVo getTime(StatisticsTimeEnum statisticsTimeEnum){


        UserAnalysisVo userAnalysisVo = new UserAnalysisVo();

        if(StatisticsTimeEnum.MONTH.equals(statisticsTimeEnum)){

            userAnalysisVo.setStartTime(dateTimeFormatter.format(LocalDateTimeUtils.monthStartTime()));
            userAnalysisVo.setEndTime(dateTimeFormatter.format(LocalDateTimeUtils.monthEndTime()));

        } else if(StatisticsTimeEnum.YEAR.equals(statisticsTimeEnum)){

            userAnalysisVo.setStartTime(dateTimeFormatter.format(LocalDateTimeUtils.yearStartTime()));
            userAnalysisVo.setEndTime(dateTimeFormatter.format(LocalDateTimeUtils.yearEndTime()));

        } else if (StatisticsTimeEnum.SEASON.equals(statisticsTimeEnum)){
            userAnalysisVo.setStartTime(dateTimeFormatter.format(LocalDateTimeUtils.quarterStartTime()));
            userAnalysisVo.setEndTime(dateTimeFormatter.format(LocalDateTimeUtils.quarterEndTime()));

        } else if(StatisticsTimeEnum.WEEK.equals(statisticsTimeEnum)){
            userAnalysisVo.setStartTime(dateTimeFormatter.format(LocalDateTimeUtils.weekStartTime()));
            userAnalysisVo.setEndTime(dateTimeFormatter.format(LocalDateTimeUtils.weekEndTime()));

        }

        return userAnalysisVo;

    }

    /**
     * 获取两个时间中的每一天
     * @param start
     * @param end
     * @return
     */
    public static List<String> getBetweenDates(String start, String end) {

        List<String> result = new ArrayList<String>();

        try {

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            Date start_date = sdf.parse(start);
            Date end_date = sdf.parse(end);

            Calendar tempStart = Calendar.getInstance();
            tempStart.setTime(start_date);
            Calendar tempEnd = Calendar.getInstance();

            tempEnd.setTime(end_date);

            while (tempStart.before(tempEnd)||tempStart.equals(tempEnd)) {

                result.add(sdf.format(tempStart.getTime()));

                tempStart.add(Calendar.DAY_OF_YEAR, 1);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //Collections.reverse(result);
        return result;

    }



        public static List<String> getDatesBetweenUsingJava8(LocalDate startDate, LocalDate endDate) {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            long numOfDaysBetween = ChronoUnit.DAYS.between(startDate, endDate);
            List<LocalDate> collect = IntStream.iterate(0, i -> i + 1)
                    .limit(numOfDaysBetween)
                    .mapToObj(i -> startDate.plusDays(i))
                    .collect(Collectors.toList());
            List<String> returnList = new ArrayList<>(collect.size());
            for (LocalDate localDate : collect) {
                returnList.add(dateTimeFormatter.format(localDate));
            }
            return returnList;
        }


}
