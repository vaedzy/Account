package com.account.bean;

import java.io.Serializable;

public class AppName implements Serializable{

    private static final long serialVersionUID = 1L;

    private long appId;
    private String appType;
    private String appName;
    private String appPinyin;

    public void setAppType(String appType) {
        this.appType = appType;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getAppType() {
        return appType;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAppName() {
        return appName;
    }

    public long getAppId() {
        return appId;
    }

    public String getAppPinyin() {
        return appPinyin;
    }

    public void setAppId(long appId) {
        this.appId = appId;
    }

    public void setAppPinyin(String appPinyin) {
        this.appPinyin = appPinyin;
    }
}
