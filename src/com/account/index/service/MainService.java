package com.account.index.service;

import com.account.bean.App;
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
     * 根据区名字查询商品
     * @param quName
     * @return
     */
    List<GoodsInfo> getAppQuGoods(String quName);

    /**
     * 根据AppId查询区服
     * @param AppId
     * @return
     */
    List<AppQu> getAppQuList(long AppId);
}
