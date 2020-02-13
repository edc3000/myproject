package com.scauly.SpringCloud.dao;

import com.scauly.SpringCloud.entities.Role;
import com.scauly.SpringCloud.entities.RoleExample;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RoleDao {
    long countByExample(RoleExample example); //按条件计数

    int deleteByExample(RoleExample example);  //按条件查询

    int deleteByPrimaryKey(String roleid);   //按主键删除

    int insert(Role record); //插入数据，返回值是ID

    int insertSelective(Role record);   //

    List<Role> selectByExample(RoleExample example);   //按条件查询

    Role selectByPrimaryKey(String roleid);   //按主键查询

    int updateByExampleSelective(@Param("record") Role record, @Param("example") RoleExample example);   //按条件更新值不为null的字段

    int updateByExample(@Param("record") Role record, @Param("example") RoleExample example);  //按条件更新

    int updateByPrimaryKeySelective(Role record);   //按主键更新值不为null的字段

    int updateByPrimaryKey(Role record);    //按主键更新
}