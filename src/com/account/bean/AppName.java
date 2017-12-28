package com.account.bean;

import java.io.Serializable;

public class AppName implements Serializable{

    private static final long serialVersionUID = 1L;

    private long AppId;
    private String AppType;
    private String AppName;
    private String AppPinyin;

    public long getAppId() {
        return AppId;
    }

    public void setAppId(long appId) {
        AppId = appId;
    }

    public String getAppName() {
        return AppName;
    }

    public void setAppName(String appName) {
        AppName = appName;
    }

    public String getAppPinyin() {
        return AppPinyin;
    }

    public void setAppPinyin(String appPinyin) {
        AppPinyin = appPinyin;
    }

    public void setAppType(String appType) {
        AppType = appType;
    }

    public String getAppType() {
        return AppType;
    }
}
