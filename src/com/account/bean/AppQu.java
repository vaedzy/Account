package com.account.bean;

import java.io.Serializable;

public class AppQu implements Serializable {

    private static final long serialVersionUID = 1L;

    private long quId;
    private long parentId;
    private String quName;
    private long appId;

    public void setAppId(long appId) {
        this.appId = appId;
    }

    public long getAppId() {
        return appId;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public long getParentId() {
        return parentId;
    }

    public long getQuId() {
        return quId;
    }

    public String getQuName() {
        return quName;
    }

    public void setParentId(long parentId) {
        this.parentId = parentId;
    }

    public void setQuId(long quId) {
        this.quId = quId;
    }

    public void setQuName(String quName) {
        this.quName = quName;
    }
}
