package com.account.index.service.impl;

import com.account.bean.App;
import com.account.bean.AppName;
import com.account.bean.AppQu;
import com.account.bean.GoodsInfo;
import com.account.common.utils.DateUtil;
import com.account.index.service.MainService;
import com.account.mapper.AppMapper;
import com.account.mapper.AppNameMapper;
import com.account.mapper.AppQuMapper;
import com.account.mapper.GoodsInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Service("mainService")
@Transactional(rollbackFor = Exception.class)
public class MainServiceImpl implements MainService{
    @Autowired(required = false)
    private AppMapper appMapper;
    @Autowired(required = false)
    private AppNameMapper appNameMapper;
    @Autowired(required = false)
    private AppQuMapper appQuMapper;
    @Autowired(required = false)
    private GoodsInfoMapper goodsInfoMapper;

    /**
     * 主导航
     * @param aAppIndex
     * @return
     */
    @Override
    public List<App> appList(String aAppIndex) {
    List<App> appList = appMapper.getAll(aAppIndex);
        return appList;
    }

    /**
     * 获取应用名字 可以根据拼音 类型查询
     * @param search
     * @return
     */
    @Override
    public Boolean getAppName(String search, HttpServletRequest request) {
        AppName appName = appNameMapper.getAppName(search);
        //如果存在
        if(appName!=null  ){
            //存入应用表数据
            request.setAttribute("appName",appName);

            //根据AppId查询区服信息
            List<AppQu> appQuList = appQuMapper.getAppQu(appName.getAppId());
            //存入request
            request.setAttribute("appQuList",appQuList);
            //获取分秒时
           String startTime = DateUtil.formatIntToDateString(new Date(),"HH:mm:ss");
            //根据appId查询下列商品
            List<GoodsInfo> goodsInfoList = goodsInfoMapper.getGoodsByAppId(appName.getAppId(),startTime);
            request.setAttribute("goodsInfoList",goodsInfoList);
            return true;
        }else{
            //不存在
            return false;
        }

    }

    /**
     * 根据AppId查询区
     * @param AppId
     * @return
     */
    @Override
    public List<AppQu> getAppQu(long AppId) {
        List<AppQu> appQuList = appQuMapper.getAppQu(AppId);
        return appQuList;
    }

    /**
     * 根据AppId查询商品
     * @param AppId
     * @return
     */
    @Override
    public List<GoodsInfo> getGoodsInfo(long AppId) {
        List<GoodsInfo> goodsInfoList = goodsInfoMapper.getGoodsByAppId(AppId);
        return goodsInfoList;
    }

    /**
     * 获取App区
     * @param quName
     * @return
     */
    public List<AppQu> getAppQuName(String quName){
        List<AppQu> appQuList = appQuMapper.getAppQuName(quName);
        return appQuList;
    }

    @Override
    public List<GoodsInfo> getGoodsInfoQu(long quId) {
        List<GoodsInfo> goodsInfoQu = goodsInfoMapper.getGoodsInfoQu(quId);
        return goodsInfoQu;
    }

    @Override
    public List<AppName> getAppNameById(long appId) {
        List<AppName> appNameList = appNameMapper.getAppNameById(appId);
        return appNameList;
    }
}
