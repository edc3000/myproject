package com.scauly.SpringCloud.service.impl;
import java.text.SimpleDateFormat;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.scauly.SpringCloud.entities.Fundorder;
import com.scauly.SpringCloud.entities.FundorderExample;
import com.scauly.SpringCloud.dao.FundorderDao;
import com.scauly.SpringCloud.service.OrderService;
import java.util.Date;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private FundorderDao orderDao;

    @Override
    public int add(Fundorder order) {

        Date dnow = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        order.setOrdertime(ft.format(dnow));
        return orderDao.insert(order);
    }

    @Override
    public Fundorder get(Long id) {
        return orderDao.selectByPrimaryKey(id);
    }

    @Override
    public List<Fundorder> selectall() {
        FundorderExample ex = new FundorderExample();
        FundorderExample.Criteria c = ex.createCriteria();
        c.andBuyeridIsNotNull();
        return orderDao.selectByExample(ex);
    }

    @Override
    public List<Fundorder> selectorder(Long id) {
        FundorderExample ex = new FundorderExample();
        FundorderExample.Criteria c = ex.createCriteria();
        c.andBuyeridEqualTo(id);
        return orderDao.selectByExample(ex);
    }

    @Override
    public List<Fundorder> selectcmporder(Long id) {
        FundorderExample ex = new FundorderExample();
        FundorderExample.Criteria c = ex.createCriteria();
        c.andSelleridEqualTo(id);
        return orderDao.selectByExample(ex);
    }
}
