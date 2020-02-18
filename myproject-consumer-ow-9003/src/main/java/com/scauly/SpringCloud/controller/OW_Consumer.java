package com.scauly.SpringCloud.controller;

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
public class OW_Consumer {
    @Autowired
    private OWClientService owClientService;

    //创建订单
    @RequestMapping(value = "consumer/ow/add", method = RequestMethod.GET)
    public int  add(@RequestBody Fundorder fundorder){
        return owClientService.add(fundorder);
    }

    //查找所有订单
    @RequestMapping(value = "consumer/ow/selectall", method = RequestMethod.GET)
    public @ResponseBody List<Fundorder> selectall(){return owClientService.selectall();}

    //查找自己的订单
    @RequestMapping(value = "consumer/ow/selectorder/{id}",method = RequestMethod.GET)
    public @ResponseBody List<Fundorder> selectorder(@PathVariable("id") Long id){return owClientService.selectorder(id);}
}
