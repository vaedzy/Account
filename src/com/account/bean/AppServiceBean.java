package com.account.bean;

import java.io.Serializable;

public class AppServiceBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private long AppServiceBeanId;
    private AppDetails appDetails;
    private long AppParentId;
    private String AppServiceName;

    public String getAppServiceName() {
        return AppServiceName;
    }

    public void setAppServiceName(String appServiceName) {
        AppServiceName = appServiceName;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public AppDetails getAppDetails() {
        return appDetails;
    }

    public long getAppParentId() {
        return AppParentId;
    }

    public long getAppServiceBeanId() {
        return AppServiceBeanId;
    }

    public void setAppDetails(AppDetails appDetails) {
        this.appDetails = appDetails;
    }

    public void setAppParentId(long appParentId) {
        AppParentId = appParentId;
    }

    public void setAppServiceBeanId(long appServiceBeanId) {
        AppServiceBeanId = appServiceBeanId;
    }
}
