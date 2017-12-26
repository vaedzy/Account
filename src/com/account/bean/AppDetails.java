package com.account.bean;

import java.io.Serializable;
import java.util.List;

public class AppDetails implements Serializable {
    private Long AppDetailsId;
    private String pingyin;//应用拼音
    private String AppName;//应用名
    private String AppType;//类型
    private List<AppServiceBean> appServiceBeans;//区服

    private static final long serialVersionUID = 1L;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public List<AppServiceBean> getAppServiceBeans() {
        return appServiceBeans;
    }

    public void setAppServiceBeans(List<AppServiceBean> appServiceBeans) {
        this.appServiceBeans = appServiceBeans;
    }

    public String getAppType() {
        return AppType;
    }

    public void setAppType(String appType) {
        AppType = appType;
    }

    public Long getAppDetailsId() {
        return AppDetailsId;
    }

    public String getAppName() {
        return AppName;
    }

    public String getPingyin() {
        return pingyin;
    }

    public void setAppDetailsId(Long appDetailsId) {
        AppDetailsId = appDetailsId;
    }

    public void setAppName(String appName) {
        AppName = appName;
    }

    public void setPingyin(String pingyin) {
        this.pingyin = pingyin;
    }

}
