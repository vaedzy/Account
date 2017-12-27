package com.account.bean;

import java.io.Serializable;
import java.util.Date;

public class AccountOrder implements Serializable {
    private Long id;

    private String aoParentId;

    private String aoIsFinish;

    private Date aoCreateTime;

    private Long aoDetailId;

    private String aoNumber;

    private String aoPayType;

    private Integer aoCommodityNumber;

    private Float aoEffectiveTime;

    private Date aoDeliveryTime;

    private String aoExoressType;

    private String aoDevelop01;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAoParentId() {
        return aoParentId;
    }

    public void setAoParentId(String aoParentId) {
        this.aoParentId = aoParentId == null ? null : aoParentId.trim();
    }

    public String getAoIsFinish() {
        return aoIsFinish;
    }

    public void setAoIsFinish(String aoIsFinish) {
        this.aoIsFinish = aoIsFinish == null ? null : aoIsFinish.trim();
    }

    public Date getAoCreateTime() {
        return aoCreateTime;
    }

    public void setAoCreateTime(Date aoCreateTime) {
        this.aoCreateTime = aoCreateTime;
    }

    public Long getAoDetailId() {
        return aoDetailId;
    }

    public void setAoDetailId(Long aoDetailId) {
        this.aoDetailId = aoDetailId;
    }

    public String getAoNumber() {
        return aoNumber;
    }

    public void setAoNumber(String aoNumber) {
        this.aoNumber = aoNumber == null ? null : aoNumber.trim();
    }

    public String getAoPayType() {
        return aoPayType;
    }

    public void setAoPayType(String aoPayType) {
        this.aoPayType = aoPayType == null ? null : aoPayType.trim();
    }

    public Integer getAoCommodityNumber() {
        return aoCommodityNumber;
    }

    public void setAoCommodityNumber(Integer aoCommodityNumber) {
        this.aoCommodityNumber = aoCommodityNumber;
    }

    public Float getAoEffectiveTime() {
        return aoEffectiveTime;
    }

    public void setAoEffectiveTime(Float aoEffectiveTime) {
        this.aoEffectiveTime = aoEffectiveTime;
    }

    public Date getAoDeliveryTime() {
        return aoDeliveryTime;
    }

    public void setAoDeliveryTime(Date aoDeliveryTime) {
        this.aoDeliveryTime = aoDeliveryTime;
    }

    public String getAoExoressType() {
        return aoExoressType;
    }

    public void setAoExoressType(String aoExoressType) {
        this.aoExoressType = aoExoressType == null ? null : aoExoressType.trim();
    }

    public String getAoDevelop01() {
        return aoDevelop01;
    }

    public void setAoDevelop01(String aoDevelop01) {
        this.aoDevelop01 = aoDevelop01 == null ? null : aoDevelop01.trim();
    }
}