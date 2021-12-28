package com.example.security.service;

import com.example.security.entity.SysMenu;

import java.util.List;

public interface SysMenuService {


    List<SysMenu> getMenu();

    List<SysMenu> getMenuAsTree();
}
