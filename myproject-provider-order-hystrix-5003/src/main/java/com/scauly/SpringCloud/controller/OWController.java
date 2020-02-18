package com.scauly.SpringCloud.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.scauly.SpringCloud.entities.Fundorder;
import com.scauly.SpringCloud.service.OrderService;
import javax.xml.ws.RequestWrapper;
import java.util.List;

@RestController
public class OWController {

    @Autowired
    private OrderService orderService;

    //创建订单
    @RequestMapping(value = "order/add", method = RequestMethod.GET)
    public int add(@RequestBody Fundorder order){
        return orderService.add(order);
    }

    //查找所有订单
    @RequestMapping(value = "order/selectall",method = RequestMethod.GET)
    public @ResponseBody List<Fundorder> selectall(){
        return orderService.selectall();
    }

    //查找所有订单
    @RequestMapping(value = "order/selectorder/{id}",method = RequestMethod.GET)
    public @ResponseBody List<Fundorder> selectorder(@PathVariable("id") Long id){
        return orderService.selectorder(id);
    }
}
