package com.example.demo.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author wuhao
 * @since 2022-01-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ProvinceBandwidth implements Serializable {

    private static final long serialVersionUID = 1L;


    private Long id;


    private Integer province;


    private Integer ispCode;

    private Integer flow;


    private String domain;


    private LocalDateTime startTime;


    private LocalDateTime endTime;


    private Integer bandwidth;


}
