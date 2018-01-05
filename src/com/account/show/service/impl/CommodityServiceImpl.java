package com.account.show.service.impl;

import com.account.bean.GoodsInfo;
import com.account.mapper.GoodsInfoMapper;
import com.account.show.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("commodityService")
@Transactional(rollbackFor = Exception.class)
public class CommodityServiceImpl implements CommodityService{
    @Autowired
    private GoodsInfoMapper goodsInfoMapper;
    @Override
    public GoodsInfo getGoogsById(long gId) {
        GoodsInfo goodsInfo = goodsInfoMapper.getGoodsById(gId);
        return goodsInfo;
    }

    @Override
    public int updateByPrimaryKey(GoodsInfo record) {
        int update = goodsInfoMapper.updateByPrimaryKey(record);
        return update;
    }

    @Override
    public int insert(GoodsInfo record) {
       int insert =  goodsInfoMapper.insert(record);
        return insert;
    }

    @Override
    public int deleteByPrimaryKey(GoodsInfo record) {
        record.setStatus(0);
       int delete =  goodsInfoMapper.deleteByPrimaryKey(record);
        return delete;
    }
}
