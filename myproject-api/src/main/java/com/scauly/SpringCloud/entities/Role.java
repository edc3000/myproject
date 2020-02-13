package com.scauly.SpringCloud.entities;

public class Role {
    private String roleid;

    private String rolename;

    private String roletype;

    private String rolepassword;

    public String getRoleid() {
        return roleid;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid == null ? null : roleid.trim();
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename == null ? null : rolename.trim();
    }

    public String getRoletype() {
        return roletype;
    }

    public void setRoletype(String roletype) {
        this.roletype = roletype == null ? null : roletype.trim();
    }

    public String getRolepassword() {
        return rolepassword;
    }

    public void setRolepassword(String rolepassword) {
        this.rolepassword = rolepassword == null ? null : rolepassword.trim();
    }
}