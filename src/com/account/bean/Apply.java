package com.account.bean;

import java.io.Serializable;
import java.util.List;

public class Apply implements Serializable{
    private static final long serialVersionUID = 2L;
    private Integer applyid;
    //应用名
    private String applyname;
    //区
    private List<String> area;
    //多对一
    private AccountIndex accountIndex;

    public AccountIndex getAccountIndex() {
        return accountIndex;
    }

    public Integer getApplyid() {
        return applyid;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getApplyname() {
        return applyname;
    }

    public void setArea(List<String> area) {
        this.area = area;
    }

    public List<String> getArea() {
        return area;
    }

    public void setAccountIndex(AccountIndex accountIndex) {
        this.accountIndex = accountIndex;
    }

    public void setApplyid(Integer applyid) {
        this.applyid = applyid;
    }

    public void setApplyname(String applyname) {
        this.applyname = applyname;
    }


}
