package com.account.index.service.impl;

import com.account.bean.App;
import com.account.bean.AppName;
import com.account.bean.AppQu;
import com.account.bean.GoodsInfo;
import com.account.index.service.MainService;
import com.account.mapper.AppMapper;
import com.account.mapper.AppNameMapper;
import com.account.mapper.AppQuMapper;
import com.account.mapper.GoodsInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    public List<App> appList(String aAppIndex) {
    List<App> appList = appMapper.getAll(aAppIndex);
        return appList;
    }

    @Override
    public List<AppName> getAppName(String search) {

        List<AppName> appNameList = appNameMapper.getAppName(search);
        return appNameList;
    }

    @Override
    public List<AppQu> getAppQu(long AppId) {
        List<AppQu> appQuList = appQuMapper.getAppQu(AppId);
        return appQuList;
    }

    @Override
    public List<GoodsInfo> getGoodsInfo(long AppId) {
        List<GoodsInfo> goodsInfoList = goodsInfoMapper.getGoodsByAppId(AppId);
        return goodsInfoList;
    }


}
