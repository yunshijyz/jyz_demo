package com.example.demo.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * region
 * </p>
 *
 * @author wuhao
 * @since 2022-01-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Region implements Serializable {

    private static final long serialVersionUID = 1L;


    private Integer id;

    private String code;

    private String name;

    private String parentCode;

    private Integer level;

    private String area;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;


}
