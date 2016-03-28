package com.lichking.pojo.web;

import java.util.Date;

public class OrderInfoPOJO {
    private String orderno;

    private Date dealdate;

    private Date dealtime;

    private String orderdetails;

    private String customerid;

    private Short status;

    public String getOrderno() {
        return orderno;
    }

    public void setOrderno(String orderno) {
        this.orderno = orderno == null ? null : orderno.trim();
    }

    public Date getDealdate() {
        return dealdate;
    }

    public void setDealdate(Date dealdate) {
        this.dealdate = dealdate;
    }

    public Date getDealtime() {
        return dealtime;
    }

    public void setDealtime(Date dealtime) {
        this.dealtime = dealtime;
    }

    public String getOrderdetails() {
        return orderdetails;
    }

    public void setOrderdetails(String orderdetails) {
        this.orderdetails = orderdetails == null ? null : orderdetails.trim();
    }

    public String getCustomerid() {
        return customerid;
    }

    public void setCustomerid(String customerid) {
        this.customerid = customerid == null ? null : customerid.trim();
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }
}