package com.account.index.service;

import com.account.bean.App;
import com.account.bean.AppName;
import com.account.bean.AppQu;
import com.account.bean.GoodsInfo;

import java.util.List;

public interface MainService {

    List<App> appList (String aAppIndex);
    List<AppName> getAppName(String search);
    List<AppQu> getAppQu(long AppId);
    List<GoodsInfo> getGoodsInfo(long AppId);

}
