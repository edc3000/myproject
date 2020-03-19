package com.scauly.SpringCloud.controller;

import com.scauly.SpringCloud.jsonForm.JsonForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.scauly.SpringCloud.entities.Role;
import com.scauly.SpringCloud.entities.RoleTO;
import com.scauly.SpringCloud.service.RoleClientService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class Role_Consumer {

    //private static final String REST_URL_PREFIX = "http://localhost:5001";

    @Autowired
    //private RestTemplate restTemplate;
    private RoleClientService roleClientService;


    //用户查重
    @RequestMapping(value = "consumer/role/findName", method = RequestMethod.POST)
    public int findName(@RequestBody Role role){
        return this.roleClientService.findN(role);
    }

    //用户密码验证
    @RequestMapping(value = "consumer/role/checkpwd", method = RequestMethod.POST)
    public @ResponseBody RoleTO checkpasswd(@RequestBody Role role){
        return this.roleClientService.checkpwd(role);
    }

    //添加用户
    @RequestMapping(value = "consumer/role/add", method = RequestMethod.POST)
    public int add(@RequestBody Role role)throws Exception{
        return this.roleClientService.add(role);
    }

    //根据ID查用户
    @RequestMapping(value = "consumer/role/get/{id}", method = RequestMethod.POST)
    public @ResponseBody Role get(@PathVariable("id") long id){
        return this.roleClientService.get(id);

    }

    //注销用户
    @RequestMapping(value = "consumer/role/delete", method = RequestMethod.POST)
    public  int delete(@RequestBody Role role){
        return this.roleClientService.delete(role);
    }

   /* //更新用户信息
    @RequestMapping(value = "consumer/role/update",method = RequestMethod.GET)
    public int updateall(@RequestBody Role role){
        return this.roleClientService.updateall(role);
    }*/

    //根据用户名就可修改密码
    @RequestMapping(value = "consumer/role/updatepwd", method = RequestMethod.POST)
    public  int updatepwd(@RequestBody Role role) throws Exception{
        return this.roleClientService.update(role);
    }

    //查找所有用户
    @RequestMapping(value = "consumer/role/selectall", method = RequestMethod.GET)
    public @ResponseBody JsonForm selectall(@RequestParam(value = "page") String page, @RequestParam(value = "limit") String limit){return roleClientService.selectall(page,limit);}

    @RequestMapping(value = "consumer/role/findRole", method = RequestMethod.POST)
    public @ResponseBody Role findRole(@RequestBody Role role) {
        return this.roleClientService.findRole(role);
    }
}
