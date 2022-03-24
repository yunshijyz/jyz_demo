package com.example.demo.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Data;

/**
 * overview_permissions
 * @author 
 */
@Data
public class OverviewPermissions implements Serializable {
    private Long id;

    private Integer parentId;

    private String name;

    private String url;

    private String rulePath;

    private Date createTime;

    private Date updateTime;

    private Integer isDelete;

    private String field;

    private Integer inPermissionsId;

    private Integer permissionsParentId;

    //子权限
    private List<OverviewPermissions> children = new ArrayList<>();

    private static final long serialVersionUID = 1L;
}