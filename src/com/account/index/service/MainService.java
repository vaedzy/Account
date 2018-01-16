package com.account.index.service;

import com.account.bean.App;
import com.account.bean.AppName;
import com.account.bean.AppQu;
import com.account.bean.GoodsInfo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface MainService {
    /**
     *
     * @param aAppIndex
     * @return
     */
    List<App> appList (String aAppIndex);

    /**
     *
     * @param search
     * @return
     */
    Boolean getAppName(String search, HttpServletRequest request);

    /**
     *
     * @param AppId
     * @return
     */
    List<AppQu> getAppQu(long AppId);

    /**
     *
     * @param AppId
     * @return
     */
    List<GoodsInfo> getGoodsInfo(long AppId);

    /**
     *
     * @param quName
     * @return
     */
    List<AppQu> getAppQuName(String quName);

    /**
     *
     * @param quId
     * @return
     */
    List<GoodsInfo> getGoodsInfoQu(long quId);

    /**
     *
     * @param appId
     * @return
     */
    List<AppName> getAppNameById(long appId);
}
