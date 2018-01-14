package com.account.commodityorder.service;

import com.account.bean.AcOrder;
import com.account.bean.GoodsInfo;
import com.account.bean.Person;

/**
 * 商品订单接口
 *
 * @author 董广斌
 * @date 2018/1/14
 * @time 20:43
 */
public interface OrderService {

    /**
     * 根据商品信息生成订单  一个商品账号 对应一个 虚拟订单
     *
     * @param person
     * @param goodsInfo
     * @return
     */
    AcOrder insertAcOrder(Person person, GoodsInfo goodsInfo);

    /**
     * 根据商品信息更新订单信息
     *
     * @param acOrder
     * @param person
     * @param goodsInfo
     * @return
     */
    AcOrder updateAcOrder(AcOrder acOrder,Person person, GoodsInfo goodsInfo);

    /**
     * 删除订单信息
     *
     * @param person
     * @param acOrder
     */
    void deleteAcOrder(Person person, AcOrder acOrder);

}
