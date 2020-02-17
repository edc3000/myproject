package com.scauly.SpringCloud.dao;

import com.scauly.SpringCloud.entities.Wallet;
import com.scauly.SpringCloud.entities.WalletExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WalletDao {
    long countByExample(WalletExample example);

    int deleteByExample(WalletExample example);

    int deleteByPrimaryKey(Long walletid);

    int insert(Wallet record);

    int insertSelective(Wallet record);

    List<Wallet> selectByExample(WalletExample example);

    Wallet selectByPrimaryKey(Long walletid);

    int updateByExampleSelective(@Param("record") Wallet record, @Param("example") WalletExample example);

    int updateByExample(@Param("record") Wallet record, @Param("example") WalletExample example);

    int updateByPrimaryKeySelective(Wallet record);

    int updateByPrimaryKey(Wallet record);
}