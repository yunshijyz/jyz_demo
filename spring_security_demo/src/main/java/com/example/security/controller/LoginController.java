package com.example.security.controller;



import com.example.security.common.api.ApiResult;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@Api(tags = "登录接口")
public class LoginController {


    @PostMapping("/login")
    public ApiResult<Map<String,String>> login(){

        Map<String,String> map = new HashMap<>();
        map.put("token","jjlkankjnc,zxcz");

        return ApiResult.ok(map);
    }
}
