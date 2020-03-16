package com.scauly.SpringCloud.controller;
import com.scauly.SpringCloud.entities.Wallet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.scauly.SpringCloud.entities.Fundorder;
import com.scauly.SpringCloud.service.OrderService;
import com.scauly.SpringCloud.service.WalletService;
import javax.xml.ws.RequestWrapper;
import java.util.List;

@RestController
public class OWController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private WalletService walletService;


    //创建订单
    @RequestMapping(value = "order/add", method = RequestMethod.POST)
    public int add(@RequestBody Fundorder order){
        return orderService.add(order);
    }

    //查找所有订单
    @RequestMapping(value = "order/selectall",method = RequestMethod.POST)
    public @ResponseBody List<Fundorder> selectall(){
        return orderService.selectall();
    }

    //查找所有自己订单
    @RequestMapping(value = "order/selectorder/{id}",method = RequestMethod.POST)
    public @ResponseBody List<Fundorder> selectorder(@PathVariable("id") Long id){
        return orderService.selectorder(id);
    }



    //创建钱包
    @RequestMapping(value = "wallet/add",method = RequestMethod.POST)
    public int add(@RequestBody Wallet wallet){ return walletService.add(wallet);}

    //查找钱包归属
    @RequestMapping(value = "wallet/findwallet/{uid}", method = RequestMethod.POST)
    public @ResponseBody Wallet findwallet(@PathVariable("uid") Long uid){return walletService.findwallet(uid);}

    //付款
    @RequestMapping(value = "wallet/pay", method = RequestMethod.POST)
    public int pay(@RequestBody Wallet wallet){return walletService.updatebuy(wallet);}

    //充值未审核
    @RequestMapping(value = "wallet/uprecharge", method = RequestMethod.POST)
    public int uprecharge(@RequestBody Wallet wallet){return walletService.updaterecharge(wallet);}

    //充值已审核
    @RequestMapping(value = "wallet/recharge",method = RequestMethod.POST)
    public int recharge(@RequestBody Wallet wallet){return walletService.recharge(wallet);}

    //提现未审核
    @RequestMapping(value = "wallet/upwithdraw",method = RequestMethod.POST)
    public int upwithdraw(@RequestBody Wallet wallet){return walletService.updatewithdraw(wallet);}

    //提现已审核
    @RequestMapping(value = "wallet/withdraw",method = RequestMethod.POST)
    public int withdraw(@RequestBody Wallet wallet){return walletService.withdraw(wallet);}

    //查找所有充值未审核的
    @RequestMapping(value = "wallet/selectrstatus", method = RequestMethod.POST)
    public @ResponseBody List<Wallet> selectrstatus(){return walletService.selectrstatus();}

    //查找所有提现未审核的
    @RequestMapping(value = "wallet/selectwstatus", method = RequestMethod.POST)
    public @ResponseBody List<Wallet> selectwstatus(){return walletService.selectwstatus();}

    //修改银行卡号
    @RequestMapping(value = "wallet/updatebandcard", method = RequestMethod.POST)
    public int changebandid(@RequestBody Wallet wallet){return walletService.updatebandcard(wallet);}

}
