package com.scauly.SpringCloud.service;

import com.scauly.SpringCloud.entities.Wallet;
import java.util.List;

public interface WalletService {

    public Wallet findwallet(Long uid);

    public int add(Wallet wallet);

    public int updatebuy(Wallet wallet);

    public int updaterecharge(Wallet wallet);

    public int updatewithdraw(Wallet wallet);

    public int recharge(Wallet wallet);

    public int withdraw(Wallet wallet);

    public List<Wallet> selectrstatus();

    public List<Wallet> selectwstatus();

}
