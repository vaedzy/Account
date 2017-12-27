package com.account.index.service;

import com.account.bean.App;
import com.account.bean.AppDetails;
import com.account.bean.AppType;
import com.account.bean.Commodity;

import java.util.List;

public interface MainService {
    List<AppType> appTypeList(String appType);
    List<App> appList (String aAppIndex);
    List<AppDetails> findApp(String AppName);
    List<Commodity> AllCommodity(String AppName);
}
