package com.scauly.SpringCloud.service;

import com.scauly.SpringCloud.entities.Role;

import java.util.List;


public interface RoleService {
    public int add(Role role) throws Exception;

    public int update(Role role);

    public int delete(Role role);

    public List<Role> findName(String name);

    public List<Role> selectrid(Role role);

    public Role  get(Long id);

    public Role checkPassword(Role role) throws Exception;

    public int updatepassword(Role role) throws Exception;
}
