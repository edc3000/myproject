package com.scauly.SpringCloud.service;

import com.scauly.SpringCloud.entities.Fundorder;


import java.util.List;

public interface OrderService {

    public int add(Fundorder order);

    public Fundorder get(Long id);

    public List<Fundorder> selectall();

    public List<Fundorder> selectorder(Long id);


    public List<Fundorder> selectcmporder(Long id);
}
