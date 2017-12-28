package com.account.index.service.impl;

import com.account.bean.App;
import com.account.index.service.MainService;
import com.account.mapper.AppMapper;
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
    private AppDetalisMapper appDetalisMapper;
    @Autowired(required = false)
    private CommodityMapper commodityMapper;


    @Override
    public List<App> appList(String aAppIndex) {
    List<App> appList = appMapper.getAll(aAppIndex);
        return appList;
    }



    @Override
    public List<Commodity> AllCommodity(String AppName) {
        List<Commodity> commodityList = commodityMapper.selectAll(AppName);
        return commodityList;
    }
}
