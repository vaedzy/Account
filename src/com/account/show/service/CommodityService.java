package com.account.show.service;

import com.account.bean.GoodsInfo;

public interface CommodityService {
    /**
     * 根据id获取商品
     * @param gId
     * @return
     */
    GoodsInfo getGoogsById(long gId);

    /**
     * 更改商品信息
     * @param record
     * @return
     */
    int updateByPrimaryKey(GoodsInfo record);

    /**
     * 插入商品
     * @param record
     * @return
     */
    int insert(GoodsInfo record);

    /**
     * 删除商品 其实是修改商品的上下架情况
     * @param record
     * @return
     */
    int deleteByPrimaryKey(GoodsInfo record);

    /**
     * 下单处理
     * @param gId
     * @return
     */
    boolean seckillGoods(long gId) throws InterruptedException;
}
