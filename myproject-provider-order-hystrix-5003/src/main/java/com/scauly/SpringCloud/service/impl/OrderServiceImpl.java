package com.scauly.SpringCloud.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.scauly.SpringCloud.entities.Fundorder;
import com.scauly.SpringCloud.entities.FundorderExample;
import com.scauly.SpringCloud.dao.FundorderDao;
import com.scauly.SpringCloud.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private FundorderDao orderDao;

    @Override
    public int add(Fundorder order) {
        return orderDao.insert(order);
    }

    @Override
    public Fundorder get(Long id) {
        return orderDao.selectByPrimaryKey(id);
    }
}
