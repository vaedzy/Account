package com.account.bean;

import java.io.Serializable;

public class App implements Serializable{

    private long aAppId;
    private String aAppname;
    private String aAppIndex;
    private static final long serialVersionUID = 1L;

    public long getaAppId() {
        return aAppId;
    }

    public void setaAppId(long aAppId) {
        this.aAppId = aAppId;
    }

    public void setaAppname(String aAppname) {
        this.aAppname = aAppname;
    }

    public String getaAppname() {
        return aAppname;
    }

    public void setaAppIndex(String aAppIndex) {
        this.aAppIndex = aAppIndex;
    }

    public String getaAppIndex() {
        return aAppIndex;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

}
