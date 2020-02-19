package com.scauly.SpringCloud.entities;

import java.io.Serializable;

public class RoleTO implements Serializable{

    Role role;
    String token;

    public Role getRole(){
        return role;
    }

    public void setRole(Role role){
        this.role=role;
    }

    public String getToken(){
        return token;
    }

    public void setToken(String token){
        this.token=token;
    }
}
