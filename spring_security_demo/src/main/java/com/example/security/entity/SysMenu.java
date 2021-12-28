package com.example.security.entity;


import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class SysMenu implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long menuId;

    private String menuName;

    private Long parentId;

    private Integer orderNum;

    private String path;

    private String component;

    private String perms;

    private String icon;

    private String remark;

    /** 子菜单 */
    private List<SysMenu> children = new ArrayList<SysMenu>();


}
