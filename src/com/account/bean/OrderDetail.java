package com.account.bean;

import java.io.Serializable;
import java.util.Date;

public class OrderDetail implements Serializable {
    private Long id;

    private Long odCommodityId;

    private Long odOrderId;

    private String odRemarks;

    private Date odCreateTime;

    private Integer odCommodityNumber;

    private String odDevelop07;

    private String odDevelop06;

    private String odDevelop05;

    private String odDevelop04;

    private String odDevelop03;

    private String odDevelop01;

    private String odDevelop02;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOdCommodityId() {
        return odCommodityId;
    }

    public void setOdCommodityId(Long odCommodityId) {
        this.odCommodityId = odCommodityId;
    }

    public Long getOdOrderId() {
        return odOrderId;
    }

    public void setOdOrderId(Long odOrderId) {
        this.odOrderId = odOrderId;
    }

    public String getOdRemarks() {
        return odRemarks;
    }

    public void setOdRemarks(String odRemarks) {
        this.odRemarks = odRemarks == null ? null : odRemarks.trim();
    }

    public Date getOdCreateTime() {
        return odCreateTime;
    }

    public void setOdCreateTime(Date odCreateTime) {
        this.odCreateTime = odCreateTime;
    }

    public Integer getOdCommodityNumber() {
        return odCommodityNumber;
    }

    public void setOdCommodityNumber(Integer odCommodityNumber) {
        this.odCommodityNumber = odCommodityNumber;
    }

    public String getOdDevelop07() {
        return odDevelop07;
    }

    public void setOdDevelop07(String odDevelop07) {
        this.odDevelop07 = odDevelop07 == null ? null : odDevelop07.trim();
    }

    public String getOdDevelop06() {
        return odDevelop06;
    }

    public void setOdDevelop06(String odDevelop06) {
        this.odDevelop06 = odDevelop06 == null ? null : odDevelop06.trim();
    }

    public String getOdDevelop05() {
        return odDevelop05;
    }

    public void setOdDevelop05(String odDevelop05) {
        this.odDevelop05 = odDevelop05 == null ? null : odDevelop05.trim();
    }

    public String getOdDevelop04() {
        return odDevelop04;
    }

    public void setOdDevelop04(String odDevelop04) {
        this.odDevelop04 = odDevelop04 == null ? null : odDevelop04.trim();
    }

    public String getOdDevelop03() {
        return odDevelop03;
    }

    public void setOdDevelop03(String odDevelop03) {
        this.odDevelop03 = odDevelop03 == null ? null : odDevelop03.trim();
    }

    public String getOdDevelop01() {
        return odDevelop01;
    }

    public void setOdDevelop01(String odDevelop01) {
        this.odDevelop01 = odDevelop01 == null ? null : odDevelop01.trim();
    }

    public String getOdDevelop02() {
        return odDevelop02;
    }

    public void setOdDevelop02(String odDevelop02) {
        this.odDevelop02 = odDevelop02 == null ? null : odDevelop02.trim();
    }
}