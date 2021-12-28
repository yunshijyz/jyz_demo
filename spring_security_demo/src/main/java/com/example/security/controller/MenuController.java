package com.example.security.controller;


import com.example.security.common.api.ApiResult;
import com.example.security.entity.SysMenu;
import com.example.security.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController {


    @Autowired
    private SysMenuService sysMenuService;

    @GetMapping
    public ApiResult<List<SysMenu>> getMenu(){
        List<SysMenu> menus = sysMenuService.getMenu();
        return ApiResult.ok(menus);
    }


    @GetMapping("/tree")
    public ApiResult<List<SysMenu>> getMenuAsTree(){
        List<SysMenu> menustree = sysMenuService.getMenuAsTree();
        return ApiResult.ok(menustree);
    }

}
