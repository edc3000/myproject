package com.scauly.SpringCloud.dao;

import com.scauly.SpringCloud.entities.Fundorder;
import com.scauly.SpringCloud.entities.FundorderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;

@Mapper
public interface FundorderDao {
    long countByExample(FundorderExample example);

    int deleteByExample(FundorderExample example);

    int deleteByPrimaryKey(Long orderid);

    int insert(Fundorder record);

    int insertSelective(Fundorder record);

    List<Fundorder> selectByExample(FundorderExample example);

    Fundorder selectByPrimaryKey(Long orderid);

    int updateByExampleSelective(@Param("record") Fundorder record, @Param("example") FundorderExample example);

    int updateByExample(@Param("record") Fundorder record, @Param("example") FundorderExample example);

    int updateByPrimaryKeySelective(Fundorder record);

    int updateByPrimaryKey(Fundorder record);
}