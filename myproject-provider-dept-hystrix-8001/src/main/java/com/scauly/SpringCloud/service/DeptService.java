package com.scauly.SpringCloud.service;

import java.util.List;

import com.scauly.SpringCloud.entities.Dept;

public interface DeptService
{
    public boolean add(Dept dept);
    public Dept    get(Long id);
    public List<Dept> list();
}
