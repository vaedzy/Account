package com.account.show.service.impl;

import com.account.bean.GoodsInfo;
import com.account.bean.SysnKeyLock;
import com.account.common.utils.ResourceLock;
import com.account.mapper.GoodsInfoMapper;
import com.account.show.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

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
    public boolean seckillGoods(long gId) throws InterruptedException {
        //查询商品是否存在
        GoodsInfo goodsInfo = goodsInfoMapper.getGoodsById(gId);
        //判断商品是否被购买
        if (goodsInfo.getStatus() != 1) {
            //被购买返回false
            return false;
        }
        //获取id
        long id = goodsInfo.getgId();
        //判断是否被上锁 上锁返回false
            //上锁
            ResourceLock.accquireWrite(id);
            try {
                System.out.println("等待付款");
                Thread.sleep(10000000);
                System.out.println("付款成功");
                goodsInfo.setStatus(0);
                //更改状态
                goodsInfoMapper.updateByPrimaryKey(goodsInfo);
                //解锁
                ResourceLock.releaseWrite(id);
                //支付成功 返回true
                return true;
            } finally {
                //如果异常 解锁
                ResourceLock.releaseWrite(id);
                return false;
            }
        }

}

