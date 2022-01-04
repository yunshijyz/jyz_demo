package com.example.demo.mapper;


import com.example.demo.entity.CommodityInfo;

public interface MysqlTestMapper {

    int deleteByPrimaryKey(String id);

    int insert(CommodityInfo record);

    int insertSelective(CommodityInfo record);

    CommodityInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CommodityInfo record);

    int updateByPrimaryKey(CommodityInfo record);
}
