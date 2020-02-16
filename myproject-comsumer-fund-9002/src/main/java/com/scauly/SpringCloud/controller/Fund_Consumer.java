package com.scauly.SpringCloud.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.scauly.SpringCloud.entities.Fund;
import com.scauly.SpringCloud.service.FundClientService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Fund_Consumer {

    @Autowired
    private FundClientService fundClientService;

    //根据名字查找
    @RequestMapping(value = "consumer/fund/selectN", method = RequestMethod.GET)
    public  @ResponseBody List<Fund> selectN(@RequestBody Fund fund){
        return fundClientService.selectName(fund);
    }

    //根据状态查找
    @RequestMapping(value = "consumer/fund/selectStatus", method = RequestMethod.GET)
    public @ResponseBody List<Fund> selectStatus(@RequestBody Fund fund){
        return fundClientService.selectStatus(fund);
    }

    //上架未审核
    @RequestMapping(value = "consumer/fund/add", method = RequestMethod.GET)
    public int add(@RequestBody Fund fund){
        return fundClientService.add(fund);
    }

    //下架
    @RequestMapping(value = "consumer/fund/delete", method = RequestMethod.GET)
    public int delete(@RequestBody Fund fund){
        return fundClientService.delete(fund);
    }

    //更新
    @RequestMapping(value = "consumer/fund/update", method = RequestMethod.GET)
    public int update(@RequestBody Fund fund){
        return fundClientService.update(fund);
    }
}
