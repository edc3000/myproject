package com.scauly.SpringCloud.service.impl;
import java.util.List;

import com.scauly.SpringCloud.jsonForm.JsonForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.scauly.SpringCloud.entities.Wallet;
import com.scauly.SpringCloud.entities.WalletExample;
import com.scauly.SpringCloud.dao.WalletDao;
import com.scauly.SpringCloud.service.WalletService;

@Service
public class WalletServiceImpl implements WalletService {

    @Autowired
    private WalletDao walletDao;

    @Override
    public Wallet findwallet(Long uid) {
        WalletExample ex = new WalletExample();
        WalletExample.Criteria c = ex.createCriteria();
        c.andOwneridEqualTo(uid);
        List<Wallet> list = walletDao.selectByExample(ex);
        if (list.isEmpty())
            return new Wallet();
        else
            return list.get(0);
    }

    @Override
    public int add(Wallet wallet) {
        long i = 0;
        wallet.setWalletmoney(i);
        wallet.setRemoney(i);
        wallet.setWdmoney(i);
        wallet.setWithdrawstatus("未提现");
        wallet.setRechargestatus("未充值");
        return walletDao.insert(wallet);
    }

    @Override
    public int updatebuy(Wallet wallet) {

        Wallet wallet1 = this.findwallet(wallet.getOwnerid());
        if (!wallet1.getWalletmoney().equals(wallet.getWalletmoney()) && wallet.getWalletmoney() != null)
            wallet1.setWalletmoney(wallet.getWalletmoney());
        return walletDao.updateByPrimaryKey(wallet1);
    }

    @Override
    public int updaterecharge(Wallet wallet) {
        Wallet wallet1 = this.findwallet(wallet.getOwnerid());
        System.out.println(wallet1.getWalletid());
        System.out.println(wallet1.getOwnerid());
        System.out.println(wallet1.getRechargestatus());
        if(wallet1.getRechargestatus().equals("未充值")) {
            wallet1.setRemoney(wallet.getRemoney()); //未充值
            wallet1.setRechargestatus("充值未审核");
            System.out.println(wallet1.getRechargestatus());
            return walletDao.updateByPrimaryKey(wallet1);
        }

        if (wallet1.getRechargestatus().equals("充值未审核")) {
            wallet1.setRemoney(wallet1.getRemoney() + wallet.getRemoney()); //充值未审核
            return walletDao.updateByPrimaryKey(wallet1);
        }

        return 0;
    }

    @Override
    public int updatewithdraw(Wallet wallet) {
        Wallet wallet1 = this.findwallet(wallet.getOwnerid());

            if (wallet1.getWithdrawstatus().equals("未提现")) {
                wallet1.setWdmoney(wallet.getWdmoney());
                wallet1.setWithdrawstatus("提现未审核");
                wallet1.setWalletmoney(wallet.getWalletmoney());
                return walletDao.updateByPrimaryKey(wallet1);
            }
            if (wallet1.getWithdrawstatus().equals("提现未审核")) {
                if (wallet1.getWalletmoney() > (wallet1.getWdmoney() + wallet.getWdmoney())) {
                    wallet1.setWdmoney(wallet1.getWdmoney() + wallet.getWdmoney());
                    wallet1.setWalletmoney(wallet.getWalletmoney());
                    return walletDao.updateByPrimaryKey(wallet1);
                }
            }


        return 0;
    }

    @Override
    public int recharge(Wallet wallet) {
        Wallet wallet1 = this.findwallet(wallet.getOwnerid());

        if(wallet1.getRechargestatus().equals("充值未审核")){
            wallet1.setWalletmoney(wallet1.getWalletmoney()+wallet1.getRemoney());
            wallet1.setRechargestatus("未充值");
            long i = 0;
            wallet1.setRemoney(i);
            return walletDao.updateByPrimaryKey(wallet1);
        }
        return 0;
    }

    @Override
    public int withdraw(Wallet wallet) {
        Wallet wallet1 = this.findwallet(wallet.getOwnerid());

        if(wallet1.getWithdrawstatus().equals("提现未审核")){

            wallet1.setWithdrawstatus("未提现");
            long i = 0;
            wallet1.setWdmoney(i);
            return walletDao.updateByPrimaryKey(wallet1);
        }
        return 0;
    }

    @Override
    public JsonForm selectrstatus(String page, String limit) {          //查找所有充值未审核的
        WalletExample ex = new WalletExample();
        WalletExample.Criteria c = ex.createCriteria();
        c.andRechargestatusEqualTo("充值未审核");
        JsonForm jsonForm = new JsonForm();
        jsonForm.setCode("0");
        jsonForm.setMsg("");
        jsonForm.setCount(walletDao.selectByExample(ex).size()+"");
        int page2 = (Integer.parseInt(page)-1)*Integer.parseInt(limit);
        ex.setOrderByClause("walletid limit "+page2+","+limit);
        jsonForm.setData(walletDao.selectByExample(ex));
        return jsonForm;
    }

    @Override
    public JsonForm selectwstatus(String page, String limit) {       //查找所有提现未审核的
        WalletExample ex = new WalletExample();
        WalletExample.Criteria c = ex.createCriteria();
        c.andWithdrawstatusEqualTo("提现未审核");
        JsonForm jsonForm = new JsonForm();
        jsonForm.setCode("0");
        jsonForm.setMsg("");
        jsonForm.setCount(walletDao.selectByExample(ex).size()+"");
        int page2 = (Integer.parseInt(page)-1)*Integer.parseInt(limit);
        ex.setOrderByClause("walletid limit "+page2+","+limit);
        jsonForm.setData(walletDao.selectByExample(ex));
        return jsonForm;
    }

    @Override
    public int updatebandcard(Wallet wallet) {
        Wallet wallet1 = this.findwallet(wallet.getOwnerid());
        wallet1.setWithdrawimage(wallet.getWithdrawimage());
        return walletDao.updateByPrimaryKey(wallet1);
    }

    @Override
    public int delwallet(Wallet wallet) {
        Wallet w = findwallet(wallet.getOwnerid());
        return walletDao.deleteByPrimaryKey(w.getWalletid());
    }


}