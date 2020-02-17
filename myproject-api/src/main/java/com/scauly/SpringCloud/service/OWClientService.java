package com.scauly.SpringCloud.service;

import com.scauly.SpringCloud.entities.Fundorder;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@FeignClient(value = "myspringcloud-fow")
public interface OWClientService {

    //创建订单
    @RequestMapping(value = "order/add", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
    public int add(@RequestBody Fundorder order);
}
