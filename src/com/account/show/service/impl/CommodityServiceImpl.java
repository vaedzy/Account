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

    /**
     * 锁商品
     * @param gId
     * @return
     */
    @Override
    public synchronized boolean seckillGoods(long gId) throws InterruptedException {
        //查询商品是否存在
        GoodsInfo goodsInfo = goodsInfoMapper.getGoodsById(gId);
        //判断商品是否被购买
        if (goodsInfo.getStatus()!=1){
            return false;
        }
        //没有被购买 执行pay中方法 并获取是否成功
        System.out.println("等待付款");
        Thread.sleep(1000);
        //如果成功 设置下架 并更新数据库
        goodsInfo.setStatus(0);
        goodsInfoMapper.updateByPrimaryKey(goodsInfo);
        return true;
    }

}
