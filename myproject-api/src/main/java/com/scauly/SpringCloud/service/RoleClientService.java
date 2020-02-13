package com.scauly.SpringCloud.service;

import com.scauly.SpringCloud.entities.Role;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "myspringcloud-role")
public interface RoleClientService {

    //查找用户名返回ID
    @RequestMapping(value = "/role/selectid", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Role selectid(@RequestBody Role role);

    //插入User
    @RequestMapping(value="/role/add",method= RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public int add(@RequestBody Role role);

    //根据id查询用户
    @RequestMapping(value="/role/get/{id}",method=RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody  Role get(@PathVariable("id") String id);

    //验证密码
    @RequestMapping(value= "/role/checkpwd", method= RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Role checkpwd(@RequestBody Role role );

    //用户名查重
    @RequestMapping(value = "/role/findN", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
    public int findN(@RequestBody Role role);
}
