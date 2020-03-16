package com.scauly.SpringCloud.controller;

import com.scauly.SpringCloud.entities.Wallet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.scauly.SpringCloud.entities.Fundorder;
import com.scauly.SpringCloud.service.OWClientService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OdandW_Consumer {

    @Autowired
    private OWClientService owClientService;

    //创建订单
    @RequestMapping(value = "consumer/order/add", method = RequestMethod.POST)
    public int  add(@RequestBody Fundorder fundorder){
        return owClientService.add(fundorder);
    }

    //查找所有订单
    @RequestMapping(value = "consumer/order/selectall", method = RequestMethod.POST)
    public @ResponseBody List<Fundorder> selectall(){return owClientService.selectall();}

    //查找自己的订单
    @RequestMapping(value = "consumer/order/selectorder/{id}",method = RequestMethod.POST)
    public @ResponseBody List<Fundorder> selectorder(@PathVariable("id") Long id){return owClientService.selectorder(id);}

    //创建钱包
    @RequestMapping(value = "consumer/wallet/add",method = RequestMethod.POST)
    public int add(@RequestBody Wallet wallet){return owClientService.add(wallet);}

    //查找钱包归属
    @RequestMapping(value = "consumer/wallet/findwallet/{uid}", method = RequestMethod.POST)
    public @ResponseBody Wallet findwallet(@PathVariable("uid") Long uid){return  owClientService.findwallet(uid);}

    //付款
    @RequestMapping(value = "consumer/wallet/pay", method = RequestMethod.POST)
    public int pay(@RequestBody Wallet wallet){return owClientService.pay(wallet);}

    //充值未审核
    @RequestMapping(value = "consumer/wallet/uprecharge", method = RequestMethod.POST)
    public int uprecharge(@RequestBody Wallet wallet){return owClientService.uprecharge(wallet);}

    //充值已审核
    @RequestMapping(value = "consumer/wallet/recharge",method = RequestMethod.POST)
    public int recharge(@RequestBody Wallet wallet){return owClientService.recharge(wallet);}

    //提现未审核
    @RequestMapping(value = "consumer/wallet/upwithdraw",method = RequestMethod.POST)
    public int upwithdraw(@RequestBody Wallet wallet){return owClientService.upwithdraw(wallet);}

    //提现已审核
    @RequestMapping(value = "consumer/wallet/withdraw",method = RequestMethod.POST)
    public int withdraw(@RequestBody Wallet wallet){return owClientService.withdraw(wallet);}

    //查找所有充值未审核的
    @RequestMapping(value = "consumer/wallet/selectrstatus", method = RequestMethod.POST)
    public @ResponseBody List<Wallet> selectrstatus(){return owClientService.selectrstatus();}

    //查找所有提现未审核的
    @RequestMapping(value = "consumer/wallet/selectwstatus", method = RequestMethod.POST)
    public @ResponseBody List<Wallet> selectwstatus(){return owClientService.selectwstatus();}

    //修改银行卡号
    @RequestMapping(value = "consumer/wallet/updatebandcard", method = RequestMethod.POST)
    public int changebandid(@RequestBody Wallet wallet){return owClientService.changebandid(wallet);}
}
