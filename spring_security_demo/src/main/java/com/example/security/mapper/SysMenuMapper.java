package com.example.security.mapper;

import com.example.security.entity.SysMenu;

import java.util.List;

public interface SysMenuMapper {

    List<SysMenu> getMenu();

    int deleteByPrimaryKey(Long menuId);

    int insert(SysMenu record);

    int insertSelective(SysMenu record);

    SysMenu selectByPrimaryKey(Long menuId);

    int updateByPrimaryKeySelective(SysMenu record);

    int updateByPrimaryKey(SysMenu record);
}
