package com.scauly.SpringCloud.service;

import com.scauly.SpringCloud.entities.Role;
import com.scauly.SpringCloud.entities.RoleTO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "myspringcloud-role")
public interface RoleClientService {

    //查找用户名返回ID
    @RequestMapping(value = "/role/selectid", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Role selectid(@RequestBody Role role);

    //插入User
    @RequestMapping(value="/role/add",method= RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public int add(@RequestBody Role role)throws Exception;

    //根据id查询用户
    @RequestMapping(value="/role/get/{id}",method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody  Role get(@PathVariable("id") Long id);

    //验证密码
    @RequestMapping(value= "/role/checkpwd", method= RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody RoleTO checkpwd(@RequestBody Role role );

    //用户名查重
    @RequestMapping(value = "/role/findN", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public int findN(@RequestBody Role role);

    //删除用户
    @RequestMapping(value = "/role/delete", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public int delete(@RequestBody Role role);

   /* //更新用户信息
    @RequestMapping(value = "/role/updateall",method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
    public  int updateall(@RequestBody Role role);*/

    //修改密码
    @RequestMapping(value = "/role/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public int update(@RequestBody Role role) throws Exception;

    //查找所有用户
    @RequestMapping(value = "role/selectall", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<Role> selectall();

    //根据名字返回对象
    @RequestMapping(value = "/role/findRole", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Role findRole(@RequestBody Role role);
}
