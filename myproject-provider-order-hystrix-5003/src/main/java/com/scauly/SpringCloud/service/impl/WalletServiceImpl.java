package com.scauly.SpringCloud.service.impl;
import java.util.List;
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
        wallet.setWithdrawstatus("0");
        wallet.setRechargestatus("0");
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
        if(wallet1.getRechargestatus().equals("0")) {
            wallet1.setRemoney(wallet.getRemoney()); //未充值
            wallet1.setRechargestatus("1");
            System.out.println(wallet1.getRechargestatus());
            return walletDao.updateByPrimaryKey(wallet1);
        }

        if (wallet1.getRechargestatus().equals("1")) {
            wallet1.setRemoney(wallet1.getRemoney() + wallet.getRemoney()); //充值未审核
            return walletDao.updateByPrimaryKey(wallet1);
        }

        return 0;
    }

    @Override
    public int updatewithdraw(Wallet wallet) {
        Wallet wallet1 = this.findwallet(wallet.getOwnerid());

        if(wallet1.getWalletmoney() > wallet.getWdmoney()) {

            if (wallet1.getWithdrawstatus().equals("0")) {
                wallet1.setWdmoney(wallet.getWdmoney());
                wallet1.setWithdrawstatus("1");
                return walletDao.updateByPrimaryKey(wallet1);
            }
            if (wallet1.getWithdrawstatus().equals("1")) {
                if (wallet1.getWalletmoney() > (wallet1.getWdmoney() + wallet.getWdmoney())) {
                    wallet1.setWdmoney(wallet1.getWdmoney() + wallet.getWdmoney());
                    return walletDao.updateByPrimaryKey(wallet1);
                }
            }
        }

        return 0;
    }

    @Override
    public int recharge(Wallet wallet) {
        Wallet wallet1 = this.findwallet(wallet.getOwnerid());

        if(wallet1.getRechargestatus().equals("1")){
            wallet1.setWalletmoney(wallet1.getWalletmoney()+wallet1.getRemoney());
            wallet1.setRechargestatus("0");
            long i = 0;
            wallet1.setRemoney(i);
            return walletDao.updateByPrimaryKey(wallet1);
        }
        return 0;
    }

    @Override
    public int withdraw(Wallet wallet) {
        Wallet wallet1 = this.findwallet(wallet.getOwnerid());

        if(wallet1.getWithdrawstatus().equals("1")){
            wallet1.setWalletmoney(wallet1.getWalletmoney()-wallet1.getWdmoney());
            wallet1.setWithdrawstatus("0");
            long i = 0;
            wallet1.setWdmoney(i);
            return walletDao.updateByPrimaryKey(wallet1);
        }
        return 0;
    }

    @Override
    public List<Wallet> selectrstatus() {          //查找所有充值未审核的
        WalletExample ex = new WalletExample();
        WalletExample.Criteria c = ex.createCriteria();
        c.andRechargestatusEqualTo("1");

        return walletDao.selectByExample(ex);
    }

    @Override
    public List<Wallet> selectwstatus() {       //查找所有提现未审核的
        WalletExample ex = new WalletExample();
        WalletExample.Criteria c = ex.createCriteria();
        c.andWithdrawstatusEqualTo("1");
        return walletDao.selectByExample(ex);
    }


}