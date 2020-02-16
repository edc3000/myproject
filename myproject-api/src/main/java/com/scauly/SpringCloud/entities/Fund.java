package com.scauly.SpringCloud.entities;

public class Fund {
    private Long fundid;

    private String fundname;

    private String fundbrief;

    private Long fundsupply;

    private Long fundprice;

    private String fundresponse;

    private Long fundcompanyid;

    private String fundstatus;

    private String fundmageurl;

    public Long getFundid() {
        return fundid;
    }

    public void setFundid(Long fundid) {
        this.fundid = fundid;
    }

    public String getFundname() {
        return fundname;
    }

    public void setFundname(String fundname) {
        this.fundname = fundname == null ? null : fundname.trim();
    }

    public String getFundbrief() {
        return fundbrief;
    }

    public void setFundbrief(String fundbrief) {
        this.fundbrief = fundbrief == null ? null : fundbrief.trim();
    }

    public Long getFundsupply() {
        return fundsupply;
    }

    public void setFundsupply(Long fundsupply) {
        this.fundsupply = fundsupply;
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

    public Long getFundcompanyid() {
        return fundcompanyid;
    }

    public void setFundcompanyid(Long fundcompanyid) {
        this.fundcompanyid = fundcompanyid;
    }

    public String getFundstatus() {
        return fundstatus;
    }

    public void setFundstatus(String fundstatus) {
        this.fundstatus = fundstatus == null ? null : fundstatus.trim();
    }

    public String getFundmageurl() {
        return fundmageurl;
    }

    public void setFundmageurl(String fundmageurl) {
        this.fundmageurl = fundmageurl == null ? null : fundmageurl.trim();
    }
}