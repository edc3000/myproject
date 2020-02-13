package com.scauly.SpringCloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.scauly.SpringCloud.entities.Role;
import com.scauly.SpringCloud.service.RoleClientService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
public class Role_Consumer {

    //private static final String REST_URL_PREFIX = "http://localhost:5001";

    @Autowired
    //private RestTemplate restTemplate;
    private RoleClientService roleClientService;


    //用户查重
    @RequestMapping(value = "consumer/role/findName", method = RequestMethod.GET)
    public int findName(@RequestBody Role role){
        return this.roleClientService.findN(role);
    }

    //用户密码验证
    @RequestMapping(value = "consumer/role/checkpwd", method = RequestMethod.GET)
    public @ResponseBody Role checkpasswd(@RequestBody Role role){
        return this.roleClientService.checkpwd(role);
    }

    //添加用户
    @RequestMapping(value = "consumer/role/add", method = RequestMethod.POST)
    public int add(@RequestBody Role role){
        return this.roleClientService.add(role);
    }

    //根据ID查用户
    @RequestMapping(value = "consumer/role/get/{id}", method = RequestMethod.GET)
    public @ResponseBody Role get(@PathVariable("id") String id){
        return this.roleClientService.get(id);

    }

}
