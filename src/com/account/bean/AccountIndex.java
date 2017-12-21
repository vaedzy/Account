package com.account.bean;

import java.io.Serializable;
import java.util.Set;

public class AccountIndex implements Serializable {
    private static final long serialVersionUID = 2L;
    //id
    private Integer accountIndexId;
    //应用名
    private String applyname;
    //一对多
    private Set<Apply> apply;

    public void setApplyname(String applyname) {
        this.applyname = applyname;
    }

    public String getApplyname() {
        return applyname;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getAccountIndexId() {
        return accountIndexId;
    }

    public Set<Apply> getApply() {
        return apply;
    }

    public void setAccountIndexId(Integer accountIndexId) {
        this.accountIndexId = accountIndexId;
    }

    public void setApply(Set<Apply> apply) {
        this.apply = apply;
    }
}
