package com.example.security.controller;


import com.example.security.entity.SysSecret;
import com.example.security.entity.SysUser;
import com.example.security.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/testDate")
@Api(tags = "测试时间")
public class DateController {


//    @Value("${token.secret}")
//    private String secret;

    @Autowired
    private SysSecret secret;

    private SysUserService sysUserService;

    public DateController(SysUserService sysUserService){
        this.sysUserService = sysUserService;
    }


    @PostMapping
    @ApiOperation("testDate")
    public String testDate(@RequestBody SysUser user){

        sysUserService.insertUser(user);

        System.out.println(secret.getSecret());


        return "success";
    }

    @PostMapping("/zidingyi")
    @ApiOperation("自定义")
    public String testDate2(){
        SysUser user = new SysUser();

        user.setUserName("ds"+System.currentTimeMillis());
        user.setPassword("ss"+System.currentTimeMillis());
        user.setLoginTime(new Date());
        sysUserService.insertUser(user);

        return "secret";
    }
}
