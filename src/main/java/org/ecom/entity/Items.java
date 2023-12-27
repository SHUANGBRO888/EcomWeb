package org.ecom.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Items {
    public Integer getGoodsID() {
        return goodsID;
    }

    public void setGoodsID(Integer goodsID) {
        this.goodsID = goodsID;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getProduceDate() {
        return produceDate;
    }

    public void setProduceDate(Date produceDate) {
        this.produceDate = produceDate;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Items{" +
                "goodsID=" + goodsID +
                ", goodsName='" + goodsName + '\'' +
                ", price=" + price +
                ", address='" + address + '\'' +
                ", produceDate=" + produceDate +
                ", picture='" + picture + '\'' +
                ", category=" + category +
                '}';
    }

    private Integer goodsID;
    private String goodsName;
    private Double price;
    private String address;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date produceDate;
    private String picture;
    private Category category;


}
