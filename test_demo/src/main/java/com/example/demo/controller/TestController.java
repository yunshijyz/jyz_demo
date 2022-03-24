package com.example.demo.controller;


import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import com.example.demo.entity.*;
import com.example.demo.service.TestService;
import com.sun.jdi.LongValue;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@Slf4j
public class TestController {

    @Autowired
    private TestService testService;

    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");


    @PostMapping("/test/demo")
    public NewDemo test(@RequestBody Demo demo){
        BigDecimal amount = demo.getAmount().subtract(demo.getNewAmount());
        NewDemo newDemo = new NewDemo();
        newDemo.setAmount(amount);
        String[] strs = demo.getStrs();
        for (String str : strs) {
            System.out.println(str);
        }
        return newDemo;

    }


    @PostMapping("/test/rock")
    public String test2(@RequestBody RockBack rockBack){
        System.out.println(rockBack.getStatisticsTime().getCode());
        System.out.println(rockBack.getStatisticsTime().getInfo());
        return "ok";
    }

    @PostMapping("/test/localdate")
    public Void test3(@RequestBody RockBack rockBack){

        WeekRes week = getWeek(rockBack.getDate());
        log.info("monday:{}",week.getMonday());
        log.info("sunday:{}",week.getSunDay());

        return null;
    }

    @PostMapping("/test/map")
    public Void test4(){

        Map<String,ProvinceUseRes> map = new HashMap<>();
        List<Region> list = testService.getList();
        for (Region region : list) {
            ProvinceUseRes res = new ProvinceUseRes();
            res.setProvince(Integer.valueOf(region.getCode()));
            res.setProvinceName(region.getName());
            map.put(region.getCode(),res);
        }

        for (String s : map.keySet()) {
            System.out.println(s+": "+map.get(s));
        }

        return null;
    }


    @GetMapping("insert")
    public String testMybatis(){


        testService.insertList();
        return "ok";
    }

    @PostMapping("province")
    public List<ProvinceRes> testMybatis1(@RequestBody UsageDistributionVo usageDistributionVo){

        List<ProvinceRes> provinceRes = testService.selectProvince(usageDistributionVo);
        log.info("provinceRes:{}",provinceRes);
        return provinceRes;
    }

    @GetMapping("/getTree")
    public List<OverviewPermissions> getTree(){
        List<OverviewPermissions> menu = testService.getMenu();
        Map<Long, OverviewPermissions> nodeMap = new HashMap<>(menu.size());
        List<OverviewPermissions> treeNode = new ArrayList<>();
        for (OverviewPermissions sysMenu : menu) {
            OverviewPermissions node = new OverviewPermissions();
            BeanUtil.copyProperties(sysMenu,node);
            nodeMap.put(node.getId(),node);
        }
        for (OverviewPermissions node : nodeMap.values()){
            Integer parentId = node.getParentId();
            OverviewPermissions parentNode = nodeMap.get(Long.valueOf(parentId));
            if(parentNode != null){
                parentNode.getChildren().add(node);
            } else {
                treeNode.add(node);
            }
        }

        return treeNode;
    }


    @GetMapping ("/tree")
    public List<Treeselect> tree(){

        List<OverviewPermissions> pers = testService.selectTree();

        List<OverviewPermissions> returnList = new ArrayList<>();
        List<Long> tempList = new ArrayList<>();
        for (OverviewPermissions overviewPermissions : pers) {
            tempList.add(overviewPermissions.getId());
        }
        for (Iterator<OverviewPermissions> iterator = pers.iterator(); iterator.hasNext();) {
            OverviewPermissions dept = (OverviewPermissions) iterator.next();
            // 如果是顶级节点, 遍历该父节点的所有子节点
            if (!tempList.contains(dept.getParentId().longValue())) {
                recursionFn(pers, dept);
                returnList.add(dept);
            }
        }
        if (returnList.isEmpty()) {
            returnList = pers;
        }
        List<Treeselect> collect = returnList.stream().map(Treeselect::new).collect(Collectors.toList());
        return collect;

    }


    /**
     * 递归列表
     */
    private void recursionFn(List<OverviewPermissions> list, OverviewPermissions t)
    {
        // 得到子节点列表
        List<OverviewPermissions> childList = getChildList(list, t);
        t.setChildren(childList);
        for (OverviewPermissions tChild : childList)
        {
            if (hasChild(list, tChild))
            {
                recursionFn(list, tChild);
            }
        }
    }

    /**
     * 判断是否有子节点
     */
    private boolean hasChild(List<OverviewPermissions> list, OverviewPermissions t)
    {
        return getChildList(list, t).size() > 0;
    }


    /**
     * 得到子节点列表
     */
    private List<OverviewPermissions> getChildList(List<OverviewPermissions> list, OverviewPermissions t)
    {
        List<OverviewPermissions> tlist = new ArrayList<OverviewPermissions>();
        Iterator<OverviewPermissions> it = list.iterator();
        while (it.hasNext())
        {
            OverviewPermissions n = (OverviewPermissions) it.next();
            if (n.getParentId() != null && n.getParentId().longValue() == t.getId().longValue())
            {
                tlist.add(n);
            }
        }
        return tlist;
    }







    private static WeekRes getWeek(String date){
        WeekRes weekRes = new WeekRes();
        LocalDateTime localDateTime = null;
        if(ObjectUtil.isNotEmpty(date)){
            String queryTime = date + " 00:00:00";
            localDateTime = LocalDateTime.parse(queryTime, dateTimeFormatter);
        } else {
            localDateTime = LocalDateTime.now();
        }
        LocalDateTime monday = localDateTime.with(TemporalAdjusters.previous(DayOfWeek.SUNDAY)).plusDays(1).withHour(0).withMinute(0).withSecond(0);
        LocalDateTime sunday = localDateTime.with(TemporalAdjusters.next(DayOfWeek.MONDAY)).minusDays(1).withHour(23).withMinute(59).withSecond(59);
        weekRes.setMonday(dateTimeFormatter.format(monday));
        weekRes.setSunDay(dateTimeFormatter.format(sunday));
        return weekRes;
    }
}
