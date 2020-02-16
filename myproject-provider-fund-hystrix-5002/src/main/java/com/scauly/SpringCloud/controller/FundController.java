package com.scauly.SpringCloud.controller;

import com.scauly.SpringCloud.entities.Fund;
import com.scauly.SpringCloud.service.FundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.RequestWrapper;
import java.util.List;

@RestController
public class FundController {

    @Autowired
    private FundService fundService;

    //根据名字查基金
    @RequestMapping(value = "fund/selectName",method = RequestMethod.GET)
    public @ResponseBody List<Fund> selectName(@RequestBody Fund fund){
        return fundService.findName(fund.getFundname());
    }

    //根据status查基金
    @RequestMapping(value = "fund/selectStatus", method = RequestMethod.GET)
    public @ResponseBody List<Fund> selectStatus(@RequestBody Fund fund){
        return fundService.selectStatus(fund.getFundstatus());
    }

    //基金上架（未审核）
    @RequestMapping(value = "fund/add", method = RequestMethod.GET)
    public int add(@RequestBody Fund fund){
        return fundService.add(fund);
    }

    //基金下架
    @RequestMapping(value = "fund/delete", method = RequestMethod.GET)
    public int delete(@RequestBody Fund fund){
        return fundService.delete(fund);
    }

    //修改基金
    @RequestMapping(value = "fund/update",method = RequestMethod.GET)
    public int update(@RequestBody Fund fund){
        return fundService.update(fund);
    }

    //get测试
    @RequestMapping(value = "fund/get/{id}", method = RequestMethod.GET)
    public @ResponseBody Fund get(@PathVariable("id") Long id){
        return fundService.get(id);
    }
}
