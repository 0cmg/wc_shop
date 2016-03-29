package com.lichking.pojo.web;

public class CommodityInfoVO {
    private Integer commodityid;

    private String name;

    private String descsimple;

    private String imageurl;

    private double price;

    private String descdetails;

    private Integer sellno;

    private String type;

    private Byte isonline;

    private Integer restno;

    public Integer getCommodityid() {
        return commodityid;
    }

    public void setCommodityid(Integer commodityid) {
        this.commodityid = commodityid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDescsimple() {
        return descsimple;
    }

    public void setDescsimple(String descsimple) {
        this.descsimple = descsimple == null ? null : descsimple.trim();
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl == null ? null : imageurl.trim();
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = Double.valueOf(price);
    }

    public String getDescdetails() {
        return descdetails;
    }

    public void setDescdetails(String descdetails) {
        this.descdetails = descdetails == null ? null : descdetails.trim();
    }

    public Integer getSellno() {
        return sellno;
    }

    public void setSellno(Integer sellno) {
        this.sellno = sellno;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Byte getIsonline() {
        return isonline;
    }

    public void setIsonline(Byte isonline) {
        this.isonline = isonline;
    }

    public Integer getRestno() {
        return restno;
    }

    public void setRestno(Integer restno) {
        this.restno = restno;
    }
}