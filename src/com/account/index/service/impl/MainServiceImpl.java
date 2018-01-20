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
     * 实现根据区名称获取商品
     * @param quName
     * @return
     */
    @Override
    public List<GoodsInfo> getAppQuGoods(String quName) {
        //根据QuName查询
        AppQu appQu = appQuMapper.getAppQuName(quName);
        //获取分秒时
        String startTime = DateUtil.formatIntToDateString(new Date(),"HH:mm:ss");
        System.out.println(appQu.getQuId());
        List<GoodsInfo> goodsInfoList = goodsInfoMapper.getGoodsInfoQu(appQu.getQuId(),startTime);
        return goodsInfoList;
    }


    @Override
    public List<AppQu> getAppQuList(long AppId) {

        List<AppQu> appQuList = appQuMapper.getAppQu(AppId);
        return appQuList;
    }


}
