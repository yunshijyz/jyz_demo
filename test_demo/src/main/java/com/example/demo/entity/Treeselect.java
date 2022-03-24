package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

public class Treeselect implements Serializable {

    /** 节点ID */
    private Long id;

    /** 节点名称 */
    private String label;

    /** 子节点 */
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Treeselect> children;


    public Treeselect()
    {

    }

    public Treeselect(OverviewPermissions dept)
    {
        this.id = dept.getId();
        this.label = dept.getName();
        this.children = dept.getChildren().stream().map(Treeselect::new).collect(Collectors.toList());
    }

    public Treeselect(SysMenu menu)
    {
        this.id = menu.getMenuId();
        this.label = menu.getMenuName();
        this.children = menu.getChildren().stream().map(Treeselect::new).collect(Collectors.toList());
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getLabel()
    {
        return label;
    }

    public void setLabel(String label)
    {
        this.label = label;
    }

    public List<Treeselect> getChildren()
    {
        return children;
    }

    public void setChildren(List<Treeselect> children)
    {
        this.children = children;
    }
}
