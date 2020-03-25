package com.scauly.SpringCloud.service;

import com.scauly.SpringCloud.entities.Fundorder;
import com.scauly.SpringCloud.entities.Wallet;
import com.scauly.SpringCloud.entities.cmyorder;
import com.scauly.SpringCloud.entities.neworder;
import com.scauly.SpringCloud.jsonForm.JsonForm;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@FeignClient(value = "myspringcloud-ow")
public interface OWClientService {

    //创建订单
    @RequestMapping(value = "order/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public int add(@RequestBody Fundorder order);

    //查找所有订单
    @RequestMapping(value = "order/selectall",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<Fundorder> selectall();

    //查找所有自己订单
    @RequestMapping(value = "order/selectorder/{id}",method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<neworder> selectorder(@PathVariable("id") Long id);

    @RequestMapping(value = "order/selectcmyorder/{id}",method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<cmyorder> selectcmyorder(@PathVariable("id") Long id);

    //创建钱包
    @RequestMapping(value = "wallet/add",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public int add(@RequestBody Wallet wallet);

    //查找钱包归属
    @RequestMapping(value = "wallet/findwallet/{uid}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Wallet findwallet(@PathVariable("uid") Long uid);

    //付款
    @RequestMapping(value = "wallet/pay", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public int pay(@RequestBody Wallet wallet);

    //充值未审核
    @RequestMapping(value = "wallet/uprecharge", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public int uprecharge(@RequestBody Wallet wallet);

    //充值已审核
    @RequestMapping(value = "wallet/recharge",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public int recharge(@RequestBody Wallet wallet);

    //提现未审核
    @RequestMapping(value = "wallet/upwithdraw",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public int upwithdraw(@RequestBody Wallet wallet);

    //提现已审核
    @RequestMapping(value = "wallet/withdraw",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public int withdraw(@RequestBody Wallet wallet);

    //查找所有充值未审核的
    @RequestMapping(value = "wallet/selectrstatus", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody JsonForm selectrstatus(@RequestParam(value = "page") String page, @RequestParam(value = "limit") String limit);

    //查找所有提现未审核的
    @RequestMapping(value = "wallet/selectwstatus", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody JsonForm selectwstatus(@RequestParam(value = "page") String page, @RequestParam(value = "limit") String limit);

    @RequestMapping(value = "wallet/updatebandcard", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public int changebandid(@RequestBody Wallet wallet);

    @RequestMapping(value = "wallet/delwallet", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public int delwallet(@RequestBody Wallet wallet);
}
