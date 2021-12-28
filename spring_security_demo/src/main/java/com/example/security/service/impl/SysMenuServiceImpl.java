package com.example.security.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.example.security.entity.SysMenu;
import com.example.security.mapper.SysMenuMapper;
import com.example.security.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class SysMenuServiceImpl implements SysMenuService {

    @Autowired
    private SysMenuMapper sysMenuMapper;

    @Override
    public List<SysMenu> getMenu() {
        return sysMenuMapper.getMenu();
    }

    @Override
    public List<SysMenu> getMenuAsTree() {
        List<SysMenu> menu = sysMenuMapper.getMenu();
        Map<Long, SysMenu> nodeMap = new HashMap<>(menu.size());
        List<SysMenu> treeNode = new ArrayList<>();
        for (SysMenu sysMenu : menu) {
            SysMenu node = new SysMenu();
            BeanUtil.copyProperties(sysMenu,node);
            nodeMap.put(node.getMenuId(),node);
        }
        for (SysMenu node : nodeMap.values()){
            Long parentId = node.getParentId();
            SysMenu parentNode = nodeMap.get(parentId);
            if(parentNode != null){
                parentNode.getChildren().add(node);
            } else {
                treeNode.add(node);
            }
        }

        return treeNode;
    }

}
