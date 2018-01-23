package com.account.bean;

import java.io.Serializable;

public class RealName implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String name;
    private String idCard;
    private String alipay;
    private String idCardUrl1;
    private String idCardUrl2;
    private Long personId;
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getIdCardUrl1() {
        return idCardUrl1;
    }

    public String getIdCardUrl2() {
        return idCardUrl2;
    }

    public void setIdCardUrl1(String idCardUrl1) {
        this.idCardUrl1 = idCardUrl1;
    }

    public void setIdCardUrl2(String idCardUrl2) {
        this.idCardUrl2 = idCardUrl2;
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

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        personId = personId;
    }
}
