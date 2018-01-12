package com.account.bean;

import java.io.Serializable;

public class RealName implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String name;
    private String idCard;
    private String alipay;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public String getAlipay() {
        return alipay;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setAlipay(String alipay) {
        this.alipay = alipay;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }
}
