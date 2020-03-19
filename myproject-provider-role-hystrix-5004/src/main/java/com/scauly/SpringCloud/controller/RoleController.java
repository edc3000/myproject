package com.scauly.SpringCloud.controller;

import com.scauly.SpringCloud.jsonForm.JsonForm;
import com.scauly.SpringCloud.service.RoleService;
import com.scauly.SpringCloud.entities.Role;
import com.scauly.SpringCloud.entities.RoleTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.scauly.SpringCloud.config.RedisUtils;
import com.scauly.SpringCloud.utils.TokenUtil;
import javax.xml.ws.RequestWrapper;
import java.util.concurrent.TimeUnit;
import java.util.List;

@RestController
public class RoleController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private RedisUtils redisUtils;

    //查找用户名返回ID
    @RequestMapping(value = "/role/selectid", method = RequestMethod.POST)
    public @ResponseBody Role selectid(@RequestBody Role role){
        List<Role> list = roleService.findName(role.getRolename());
        if(list.isEmpty())
            return new Role();
        else
            return list.get(0);
    }

    //查找所有用户
    @RequestMapping(value = "role/selectall", method = RequestMethod.GET)
    public @ResponseBody JsonForm selectall(@RequestParam(value = "page") String page, @RequestParam(value = "limit") String limit){return roleService.selectall(page,limit);}

    //插入User
    @RequestMapping(value="/role/add",method= RequestMethod.POST)
    public int add(@RequestBody Role role) throws Exception {
        //redisUtils.set(role.getRoleid().toString(), role, 10L, TimeUnit.MINUTES);
        //redisUtils.set(role.getRolename(), role.getRoleid().toString(),10L,TimeUnit.MINUTES);
        return roleService.add(role);
    }

    //根据id查询用户
    @RequestMapping(value="/role/get/{id}",method=RequestMethod.POST)
    public @ResponseBody  Role get(@PathVariable("id") Long id)
    {
        return roleService.get(id);
    }

    //验证密码
    @RequestMapping(value= "/role/checkpwd", method= RequestMethod.POST)
    public @ResponseBody RoleTO checkpwd(@RequestBody Role role ) throws Exception{
        RoleTO roleto = new RoleTO();
        Role role1 = roleService.checkPassword(role);
        if(role1.getRoleid()!=null){

            String token = TokenUtil.genUniqueKey(role1.getRolename());
            redisUtils.set(token, role1.getRoleid().toString(), 30L, TimeUnit.MINUTES);
            roleto.setToken(token);
        }
        roleto.setRole(role1);
        return roleto;
    }

    //用户名查重
    @RequestMapping(value = "/role/findN", method = RequestMethod.POST)
    public int findN(@RequestBody Role role){
        List<Role> list = roleService.findName(role.getRolename());
        System.out.println("测试测试");
        if(list.isEmpty())
            return 1;
        else
            return 0;
    }

    @RequestMapping(value = "/role/findRole", method = RequestMethod.POST)
    public @ResponseBody Role findRole(@RequestBody Role role){
        List<Role> list = roleService.findName(role.getRolename());
        if(list.isEmpty())
            return new Role();
        else
            return list.get(0);
    }

    //删除用户
    @RequestMapping(value = "/role/delete", method = RequestMethod.POST)
    public int delete(@RequestBody Role role){
        return this.roleService.delete(role);
    }

   /* //更新用户信息
    @RequestMapping(value = "/role/updateall",method = RequestMethod.GET)
    public  int updateall(@RequestBody Role role){
        return this.roleService.update(role);
    }*/

    //修改密码
    @RequestMapping(value = "/role/update", method = RequestMethod.POST)
    public int update(@RequestBody Role role) throws Exception{

        return  this.roleService.updatepassword(role);
    }

}
