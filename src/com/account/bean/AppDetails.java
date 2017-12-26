package com.account.bean;

import java.io.Serializable;

public class AppDetails implements Serializable {
    private Long AppDetailsId;
    private String pingyin;
    private String AppName;
    private String Service;
    private String CommodityId;
    private static final long serialVersionUID = 1L;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getAppDetailsId() {
        return AppDetailsId;
    }

    public String getAppName() {
        return AppName;
    }

    public String getCommodityId() {
        return CommodityId;
    }

    public String getPingyin() {
        return pingyin;
    }

    public void setAppDetailsId(Long appDetailsId) {
        AppDetailsId = appDetailsId;
    }

    public String getService() {
        return Service;
    }

    public void setAppName(String appName) {
        AppName = appName;
    }

    public void setCommodityId(String commodityId) {
        CommodityId = commodityId;
    }

    public void setPingyin(String pingyin) {
        this.pingyin = pingyin;
    }

    public void setService(String service) {
        Service = service;
    }
}
