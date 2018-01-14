package com.account.commodityorder.service.impl;

import com.account.bean.AcOrder;
import com.account.bean.GoodsInfo;
import com.account.bean.Person;
import com.account.commodityorder.service.OrderService;
import com.account.common.utils.DateUtil;
import com.account.common.utils.StringUtil;
import com.account.mapper.AcOrderMapper;
import com.account.mapper.GoodsInfoMapper;
import oracle.sql.DATE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @author 董广斌
 * @date 2018/1/14
 * @time 20:44
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class OrderServiceImpl implements OrderService {
    @Autowired(required = false)
    private AcOrderMapper acOrderMapper;
    @Autowired(required = false)
    private GoodsInfoMapper goodsInfoMapper;

    /**
     * 根据商品信息生成订单  一个商品账号 对应一个 虚拟订单
     *
     * @param person
     * @param goodsInfo
     * @return
     */
    @Override
    public AcOrder insertAcOrder(Person person, GoodsInfo goodsInfo) {
        //判断该用户是否进行身份验证，如果没有身份验证则返回空值
        if (!StringUtil.isBlank(person.getpCertificateNumber())) {
            AcOrder acOrder = new AcOrder();
            //身份证
            acOrder.setoUserCode(person.getpCertificateNumber());
            //查询该人员当天是否生成订单
            AcOrder lastOrderNow = acOrderMapper.getLastOrderNow(person.getpCertificateNumber());
            if (lastOrderNow != null) {
                acOrder.setoCode(lastOrderNow.getoCode() + 1);
            } else {
                String dateString = DateUtil.formatIntToDateString(new Date(), "yyyy-MM-dd");
                acOrder.setoCode(dateString + "01");
            }
            acOrder.setoCreateTime(new Date());
            GoodsInfo goodsById = goodsInfoMapper.getGoodsById(goodsInfo.getgId());
            acOrder.setoGiId(goodsById.getgId());
            goodsById.setStatus(0);
            acOrderMapper.insert(acOrder);
            goodsInfoMapper.updateByPrimaryKey(goodsById);
            return acOrder;
        } else {
            return null;
        }
    }

    /**
     * 根据商品信息更新订单信息
     *
     * @param acOrder
     * @param person
     * @param goodsInfo
     * @return
     */
    @Override
    public AcOrder updateAcOrder(AcOrder acOrder, Person person, GoodsInfo goodsInfo) {

        acOrder.setoGiId(goodsInfo.getgId());
        goodsInfo.setStatus(0);
        acOrderMapper.updateByPrimaryKey(acOrder);
        goodsInfoMapper.updateByPrimaryKey(goodsInfo);
        return acOrder;
    }

    /**
     * 删除订单信息
     *
     * @param person
     * @param acOrder
     */
    @Override
    public void deleteAcOrder(Person person, AcOrder acOrder) {
        acOrderMapper.deleteByPrimaryKey(acOrder.getId());
        /**
         * 此处 删除的是未支付订单
         */
        GoodsInfo goodsById = goodsInfoMapper.getGoodsById(acOrder.getoGiId());
        goodsById.setStatus(1);
        goodsInfoMapper.updateByPrimaryKey(goodsById);
    }
}
