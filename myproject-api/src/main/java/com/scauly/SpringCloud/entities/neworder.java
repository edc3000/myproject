package com.scauly.SpringCloud.entities;

public class neworder {
    private String fundname;

    private Long fundprice;

    private String fundresponse;

    private Long orderid;

    private Long fundid;

    private String ordertime;

    public Long getOrderid() {
        return orderid;
    }

    public void setOrderid(Long orderid) {
        this.orderid = orderid;
    }

    public Long getFundid() {
        return fundid;
    }

    public void setFundid(Long fundid) {
        this.fundid = fundid;
    }

    public String getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(String ordertime) {
        this.ordertime = ordertime == null ? null : ordertime.trim();
    }

    public String getFundname() {
        return fundname;
    }

    public void setFundname(String fundname) {
        this.fundname = fundname == null ? null : fundname.trim();
    }

    public Long getFundprice() {
        return fundprice;
    }

    public void setFundprice(Long fundprice) {
        this.fundprice = fundprice;
    }

    public String getFundresponse() {
        return fundresponse;
    }

    public void setFundresponse(String fundresponse) {
        this.fundresponse = fundresponse == null ? null : fundresponse.trim();
    }
}
