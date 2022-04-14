package com.demo.mybatis_plus.mybatis_plus_demo;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.demo.mybatis_plus.mybatis_plus_demo.entity.User;
import com.demo.mybatis_plus.mybatis_plus_demo.entity.UserInfo;
import com.demo.mybatis_plus.mybatis_plus_demo.service.IUserInfoService;
import com.demo.mybatis_plus.mybatis_plus_demo.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
@Slf4j
class MybatisPlusDemoApplicationTests {

    @Resource
    private IUserService userService;

    @Resource
    private IUserInfoService userInfoService;

    @Test
    void contextLoads() {
    }

    @Test
    void Test(){
        User byId = userService.getById(1L);
        log.info("user:{}",byId);
    }

    @Test
    void Test2(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        //queryWrapper.select("name");

        List<User> list = userService.list();
        list.forEach(System.out::println);

    }



    @Test
    void Test3(){

        Page<User> page = new Page<>();
        page.setCurrent(2l);
        page.setSize(2);
        LambdaQueryWrapper lambdaQueryWrapper = new LambdaQueryWrapper();
        //queryWrapper.select("name");
        Page<User> pageRecord = userService.page(page);
        //pageRecord.getRecords().forEach(System.out::println);
        //System.out.println(pageRecord.getPages());
        //System.out.println(pageRecord.getTotal());
        //System.out.println(pageRecord.getCurrent());
        //System.out.println(pageRecord.getSize());
        System.out.println(pageRecord);

    }

    @Test
    void Test4(){
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.between("user_id",10L,20L);
        //queryWrapper.notIn("user_status",0);
        List<UserInfo> list = userInfoService.list(queryWrapper);
        list.forEach(System.out::println);


    }


    @Test
    void Test5(){
        List<UserInfo> list = userInfoService.list();
        list.forEach(System.out::println);

    }

}
