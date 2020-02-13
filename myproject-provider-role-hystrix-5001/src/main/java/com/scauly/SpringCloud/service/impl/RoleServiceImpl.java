package com.scauly.SpringCloud.service.impl;

import com.scauly.SpringCloud.entities.Role;
import com.scauly.SpringCloud.entities.RoleExample;
import com.scauly.SpringCloud.service.RoleService;
import com.scauly.SpringCloud.dao.RoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;


    public static String md5(String text, String key) throws Exception {
        //加密后的字符串
        String encodeStr= DigestUtils.md5DigestAsHex((text + key).getBytes());
        System.out.println("MD5加密后的字符串为:encodeStr="+encodeStr);
        return encodeStr;
    }

    public static boolean verify(String text, String key, String md5) throws Exception {
        //根据传入的密钥进行验证
        String md5Text = md5(text, key);
        if(md5Text.equalsIgnoreCase(md5))
        {
            System.out.println("MD5验证通过");
            return true;
        }

        return false;
    }

    @Override
    public int add(Role role) {
        return roleDao.insert(role);
    }

    @Override
    public int update(Role role) {
        return roleDao.updateByPrimaryKey(role);
    }

    @Override
    public int delete(Role role) {
        return roleDao.deleteByPrimaryKey(role.getRoleid());
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
    public Role get(String id) {
        return roleDao.selectByPrimaryKey(id);
    }

    @Override
    public Role checkPassword(Role role) throws Exception {
        List<Role> list = this.findName(role.getRolename());
        if(list.isEmpty())
            return new Role();
        Role role1 = list.get(0);
        if(verify(role.getRolepassword(),"abcd4321", role1.getRolepassword()))
            return role1;
        else
            return new Role();
    }



}
