package com.scauly.SpringCloud.entities;

public class Fundorder {
    private Long orderid;

    private Long buyerid;

    private Long sellerid;

    private Long fundid;

    public Long getOrderid() {
        return orderid;
    }

    public void setOrderid(Long orderid) {
        this.orderid = orderid;
    }

    public Long getBuyerid() {
        return buyerid;
    }

    public void setBuyerid(Long buyerid) {
        this.buyerid = buyerid;
    }

    public Long getSellerid() {
        return sellerid;
    }

    public void setSellerid(Long sellerid) {
        this.sellerid = sellerid;
    }

    public Long getFundid() {
        return fundid;
    }

    public void setFundid(Long fundid) {
        this.fundid = fundid;
    }
}