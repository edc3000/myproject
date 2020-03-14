package com.scauly.SpringCloud.service.impl;

import com.scauly.SpringCloud.entities.Fund;
import com.scauly.SpringCloud.entities.FundExample;
import com.scauly.SpringCloud.service.FundService;
import com.scauly.SpringCloud.dao.FundDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.scauly.SpringCloud.jsonForm.JsonForm;

@Service
public class FundServiceImpl implements FundService {

    @Autowired
    private FundDao fundDao;

    @Override
    public int add(Fund fund) {
        fund.setFundstatus("上架未审核");
        return fundDao.insert(fund);
    }

    @Override
    public int update(Fund fund) {
        List<Fund> list = this.findName(fund.getFundname());
        if (list.isEmpty())
            return 0;
        else {
            Fund fund1 = list.get(0);
            if (!fund1.getFundname().equals(fund.getFundname()) && fund.getFundname() != null)
                fund1.setFundname(fund.getFundname());

            if (!fund1.getFundbrief().equals(fund.getFundbrief()) && fund.getFundbrief() != null)
                fund1.setFundbrief(fund.getFundbrief());

            if (!fund1.getFundresponse().equals(fund.getFundresponse()) && fund.getFundresponse() != null)
                fund1.setFundresponse(fund.getFundresponse());

            if (!fund1.getFundmageurl().equals(fund.getFundmageurl()) && fund.getFundmageurl() != null)
                fund1.setFundmageurl(fund.getFundmageurl());

            if (!fund1.getFundprice().equals(fund.getFundprice()) && fund.getFundprice() != null)
                fund1.setFundprice(fund.getFundprice());

            if (!fund1.getFundsupply().equals(fund.getFundsupply()) && fund.getFundsupply() != null)
                fund1.setFundsupply(fund.getFundsupply());

            if (!fund1.getFundstatus().equals(fund.getFundstatus()) && fund.getFundstatus() != null)
                fund1.setFundstatus(fund.getFundstatus());

            return fundDao.updateByPrimaryKey(fund1);
        }
    }

    @Override
    public int delete(Fund fund) {
        List<Fund> list = this.findName(fund.getFundname());
        if (list.isEmpty())
            return 0;
        else {
            Fund fund1 = list.get(0);
            return fundDao.deleteByPrimaryKey(fund1.getFundid());
        }
    }

    @Override
    public List<Fund> findName(String name) {
        FundExample ex = new FundExample();
        FundExample.Criteria c = ex.createCriteria();
        c.andFundnameEqualTo(name);

        return fundDao.selectByExample(ex);
    }

    @Override
    public Fund get(Long id) {
        return fundDao.selectByPrimaryKey(id);
    }

    @Override
    public List<Fund> selectid(Fund fund) {
        FundExample ex = new FundExample();
        FundExample.Criteria c = ex.createCriteria();
        c.andFundnameEqualTo(fund.getFundname());

        return fundDao.selectByExample(ex);
    }

    @Override
    public List<Fund> selectStatus(String status) {
        FundExample ex = new FundExample();
        FundExample.Criteria c = ex.createCriteria();
        c.andFundstatusEqualTo(status);

        return fundDao.selectByExample(ex);
    }

    @Override
    public int buy(Fund fund) {
        List<Fund> list = this.findName(fund.getFundname());
        if (list.isEmpty())
            return 0;
        else {
            Fund fund1 = list.get(0);
            if (fund1.getFundsupply() < 1)
                return 0;
            else {
                fund1.setFundsupply((fund1.getFundsupply() - 1));
                return fundDao.updateByPrimaryKey(fund1);
            }
        }

    }

    @Override
    public JsonForm selectall(Long id,String page, String limit) {
        FundExample ex = new FundExample();
        FundExample.Criteria c = ex.createCriteria();
        c.andFundcompanyidEqualTo(id);
        JsonForm jsonForm = new JsonForm();
        jsonForm.setCode("0");
        jsonForm.setMsg("");
        jsonForm.setCount(fundDao.selectByExample(ex).size()+"");
        int page2 = (Integer.parseInt(page)-1)*Integer.parseInt(limit);
        ex.setOrderByClause("fundid limit "+page2+","+limit);
        jsonForm.setData(fundDao.selectByExample(ex));
        return jsonForm;
    }
}