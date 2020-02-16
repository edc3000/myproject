package com.scauly.SpringCloud.dao;

import com.scauly.SpringCloud.entities.Fund;
import com.scauly.SpringCloud.entities.FundExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FundMapper {
    long countByExample(FundExample example);

    int deleteByExample(FundExample example);

    int deleteByPrimaryKey(Long fundid);

    int insert(Fund record);

    int insertSelective(Fund record);

    List<Fund> selectByExample(FundExample example);

    Fund selectByPrimaryKey(Long fundid);

    int updateByExampleSelective(@Param("record") Fund record, @Param("example") FundExample example);

    int updateByExample(@Param("record") Fund record, @Param("example") FundExample example);

    int updateByPrimaryKeySelective(Fund record);

    int updateByPrimaryKey(Fund record);
}