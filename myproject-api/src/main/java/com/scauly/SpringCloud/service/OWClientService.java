package com.scauly.SpringCloud.service;

import com.scauly.SpringCloud.entities.Fundorder;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@FeignClient(value = "myspringcloud-orderAndwallet")
public interface OWClientService {

    //创建订单
    @RequestMapping(value = "order/add", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
    public int add(@RequestBody Fundorder order);

    //查找所有订单
    @RequestMapping(value = "order/selectall",method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<Fundorder> selectall();

    @RequestMapping(value = "order/selectorder/{id}",method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<Fundorder> selectorder(@PathVariable("id") Long id);
}
