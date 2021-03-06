package com.scauly.SpringCloud.service.impl;

import com.scauly.SpringCloud.entities.Role;
import com.scauly.SpringCloud.entities.RoleExample;
import com.scauly.SpringCloud.jsonForm.JsonForm;
import com.scauly.SpringCloud.service.RoleService;
import com.scauly.SpringCloud.dao.RoleDao;
import com.scauly.SpringCloud.utils.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;



    @Override
    public int add(Role role) throws Exception {
        System.out.println("密码："+role.getRolepassword());
       role.setRolepassword( Md5Util.md5(role.getRolepassword(),"abcd4321"));

        return roleDao.insert(role);
    }

    @Override
    public int update(Role role) {
        return roleDao.updateByPrimaryKey(role);
    }

    @Override
    public int delete(Role role) {
        List<Role> list = this.findName(role.getRolename());
        if(list.isEmpty())
            return 0;
        else
        {
            Role role1 = list.get(0);
            System.out.println(role1.getRoleid());
            return roleDao.deleteByPrimaryKey(role1.getRoleid());
        }
    }

    @Override
    public List<Role> findName(String name) {

        RoleExample ex = new RoleExample();
        RoleExample.Criteria c = ex.createCriteria();
        c.andRolenameEqualTo(name);
        return roleDao.selectByExample(ex);
    }

    @Override
    public List<Role> selectrid(Role role) {
        RoleExample ex = new RoleExample();
        RoleExample.Criteria c = ex.createCriteria();
        c.andRolenameEqualTo(role.getRolename());
        return roleDao.selectByExample(ex);
    }



    @Override
    public Role get(Long id) {
        return roleDao.selectByPrimaryKey(id);
    }

    @Override
    public Role checkPassword(Role role) throws Exception {
        List<Role> list = this.findName(role.getRolename());
        if(list.isEmpty())
            return new Role();
        Role role1 = list.get(0);
        if(Md5Util.verify(role.getRolepassword(),"abcd4321", role1.getRolepassword()))
            return role1;
        else
            return new Role();
    }

    @Override
    public int updatepassword(Role role) throws Exception {
        /*Role role1 = roleDao.selectByPrimaryKey(role.getRoleid());

            role1.setRolepassword(md5(role.getRolepassword(),"abcd4321"));
            System.out.println("修改密码");

        return roleDao.updateByPrimaryKey(role1);*/
        List<Role> list = this.findName(role.getRolename());
        if(list.isEmpty())
            return 0;
        else
        {
            Role role1 = list.get(0);
            System.out.println("1121212");
            role1.setRolepassword(Md5Util.md5(role.getRolepassword(),"abcd4321"));
            System.out.println("修改密码");
            return roleDao.updateByPrimaryKey(role1);
        }
    }

    @Override
    public JsonForm selectall(String page, String limit) {
        RoleExample ex = new RoleExample();
        RoleExample.Criteria c = ex.createCriteria();
        c.andRoleidNotEqualTo((long)8);
        JsonForm jsonForm = new JsonForm();
        jsonForm.setCode("0");
        jsonForm.setMsg("");
        jsonForm.setCount(roleDao.selectByExample(ex).size()+"");
        int page2 = (Integer.parseInt(page)-1)*Integer.parseInt(limit);
        ex.setOrderByClause("roleid limit "+page2+","+limit);
        jsonForm.setData(roleDao.selectByExample(ex));
        return jsonForm;
    }


}
