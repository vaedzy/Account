package com.account.index.service;

import com.account.bean.App;
import com.account.bean.AppName;

import java.util.List;

public interface MainService {

    List<App> appList (String aAppIndex);
    List<AppName> getAppName(String search);

}
