package com.account.index.service;

import com.account.bean.App;
import com.account.bean.AppName;
import com.account.bean.AppQu;
import com.account.bean.GoodsInfo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface MainService {
    /**
     * 主导航
     * @param aAppIndex
     * @return
     */
    List<App> appList (String aAppIndex);

    /**
     * 获取应用名字 可以根据拼音 类型查询
     * @param search
     * @return
     */
    Boolean getAppName(String search, HttpServletRequest request);

    /**
     * 根据AppId查询区
     * @param AppId
     * @return
     */
    List<AppQu> getAppQu(long AppId);

    /**
     * 根据AppId查询商品
     * @param AppId
     * @return
     */
    List<GoodsInfo> getGoodsInfo(long AppId);

    /**
     * 获取App区
     * @param quName
     * @return
     */
    List<AppQu> getAppQuName(String quName);

    /**
     * 根据区id获取商品
     * @param quId
     * @return
     */
    List<GoodsInfo> getGoodsInfoQu(long quId);

    /**
     * 根据appid获取应用
     * @param appId
     * @return
     */
    List<AppName> getAppNameById(long appId);
}
