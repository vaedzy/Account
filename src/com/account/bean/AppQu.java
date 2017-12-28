package com.account.bean;

import java.io.Serializable;

public class AppQu implements Serializable {

    private static final long serialVersionUID = 1L;

    private long QuId;
    private long ParentId;
    private String QuName;
    private long AppId;

    public void setAppId(long appId) {
        AppId = appId;
    }

    public long getAppId() {
        return AppId;
    }

    public long getParentId() {
        return ParentId;
    }

    public long getQuId() {
        return QuId;
    }

    public String getQuName() {
        return QuName;
    }

    public void setParentId(long parentId) {
        ParentId = parentId;
    }

    public void setQuId(long quId) {
        QuId = quId;
    }

    public void setQuName(String quName) {
        QuName = quName;
    }

}
