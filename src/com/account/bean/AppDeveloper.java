package com.account.bean;

import java.io.Serializable;

/**
 * 预留接口 提供给App开发者使用 用于冻结账号
 */
public class AppDeveloper implements Serializable {
    private static final long serialVersionUID = 1L;
    private long id;
    private String appName;
    private String account;
    private String startTime;
    private String terminalTime;
    private String appDeveloper;

    public String getAppDeveloper() {
        return appDeveloper;
    }

    public void setAppDeveloper(String appDeveloper) {
        this.appDeveloper = appDeveloper;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getTerminalTime() {
        return terminalTime;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public void setTerminalTime(String terminalTime) {
        this.terminalTime = terminalTime;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

}
