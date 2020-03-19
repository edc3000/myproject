package com.scauly.SpringCloud.service;

import com.scauly.SpringCloud.entities.Wallet;
import com.scauly.SpringCloud.jsonForm.JsonForm;

import java.util.List;

public interface WalletService {

    public Wallet findwallet(Long uid);

    public int add(Wallet wallet);

    public int updatebuy(Wallet wallet);

    public int updaterecharge(Wallet wallet);

    public int updatewithdraw(Wallet wallet);

    public int recharge(Wallet wallet);

    public int withdraw(Wallet wallet);

    public JsonForm selectrstatus(String page, String limit);

    public JsonForm selectwstatus(String page, String limit);

    public int updatebandcard(Wallet wallet);

    public int delwallet(Wallet wallet);
}
