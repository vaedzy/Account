package com.account.bean;

import java.io.Serializable;
import java.util.Date;

public class AcOrder implements Serializable {
    private Long id;

    private String oCode;

    private String oPayType;

    private String oUserCode;

    private Date oCreateTime;

    private Long oGiId;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getoCode() {
        return oCode;
    }

    public void setoCode(String oCode) {
        this.oCode = oCode == null ? null : oCode.trim();
    }

    public String getoPayType() {
        return oPayType;
    }

    public void setoPayType(String oPayType) {
        this.oPayType = oPayType == null ? null : oPayType.trim();
    }

    public String getoUserCode() {
        return oUserCode;
    }

    public void setoUserCode(String oUserCode) {
        this.oUserCode = oUserCode == null ? null : oUserCode.trim();
    }

    public Date getoCreateTime() {
        return oCreateTime;
    }

    public void setoCreateTime(Date oCreateTime) {
        this.oCreateTime = oCreateTime;
    }

    public Long getoGiId() {
        return oGiId;
    }

    public void setoGiId(Long oGiId) {
        this.oGiId = oGiId;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
}