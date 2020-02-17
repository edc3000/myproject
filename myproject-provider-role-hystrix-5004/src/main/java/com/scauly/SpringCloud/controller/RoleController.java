package com.scauly.SpringCloud.controller;

import com.scauly.SpringCloud.service.RoleService;
import com.scauly.SpringCloud.entities.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.RequestWrapper;
import java.util.List;

@RestController
public class RoleController {

    @Autowired
    private RoleService roleService;

    //查找用户名返回ID
    @RequestMapping(value = "/role/selectid", method = RequestMethod.GET)
    public @ResponseBody Role selectid(@RequestBody Role role){
        List<Role> list = roleService.findName(role.getRolename());
        if(list.isEmpty())
            return new Role();
        else
            return list.get(0);
    }

    //插入User
    @RequestMapping(value="/role/add",method= RequestMethod.POST)
    public int add(@RequestBody Role role) throws Exception {
        return roleService.add(role);
    }

    //根据id查询用户
    @RequestMapping(value="/role/get/{id}",method=RequestMethod.GET)
    public @ResponseBody  Role get(@PathVariable("id") Long id)
    {
        return roleService.get(id);
    }

    //验证密码
    @RequestMapping(value= "/role/checkpwd", method= RequestMethod.GET)
    public @ResponseBody Role checkpwd(@RequestBody Role role ) throws Exception{
        return roleService.checkPassword(role);
    }

    //用户名查重
    @RequestMapping(value = "/role/findN", method = RequestMethod.GET)
    public int findN(@RequestBody Role role){
        List<Role> list = roleService.findName(role.getRolename());
        if(list.isEmpty())
            return 1;
        else
            return 0;
    }

    //删除用户
    @RequestMapping(value = "/role/delete", method = RequestMethod.GET)
    public int delete(@RequestBody Role role){
        return this.roleService.delete(role);
    }

   /* //更新用户信息
    @RequestMapping(value = "/role/updateall",method = RequestMethod.GET)
    public  int updateall(@RequestBody Role role){
        return this.roleService.update(role);
    }*/

    //修改密码
    @RequestMapping(value = "/role/update", method = RequestMethod.GET)
    public int update(@RequestBody Role role) throws Exception{
        return  this.roleService.updatepassword(role);
    }

}
