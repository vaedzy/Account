package com.account.show.service.impl;

import com.account.bean.Deposit;
import com.account.bean.GoodsInfo;
import com.account.bean.Person;
import com.account.bean.RealName;

import com.account.common.utils.ResourceLock;
import com.account.mapper.DepositMapper;
import com.account.mapper.GoodsInfoMapper;
import com.account.mapper.RealNameMapper;
import com.account.show.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;


@Service("commodityService")
@Transactional(rollbackFor = Exception.class)
public class CommodityServiceImpl implements CommodityService{
    @Autowired
    private GoodsInfoMapper goodsInfoMapper;
    @Autowired
    private RealNameMapper realNameMapper;
    @Autowired
    private DepositMapper depositMapper;
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
     * 发布商品前确认实名认证
     * @param httpSession
     * @return
     */
    @Override
    public Boolean RealName(HttpSession httpSession) {
        Person person = (Person) httpSession.getAttribute("user");
        RealName realName = realNameMapper.getRealNameByPrimaryKey(person.getId());
        if (realName!=null){
            return true;
        }
        return false;
    }

    /**
     * 锁商品
     * @param gId
     * @return
     */
    @Override
    public String seckillGoods(long gId,HttpSession httpSession) throws InterruptedException {
        //查询商品是否存在
        GoodsInfo goodsInfo = goodsInfoMapper.getGoodsById(gId);
        //查询下单用户是否实名认证
        Person person = (Person) httpSession.getAttribute("user");
        RealName realName = realNameMapper.getRealNameByPrimaryKey(person.getId());
        if (realName==null){
            return "noRealName";
        }
        //查询下单用户是否缴纳押金
        Deposit deposit = depositMapper.getDepositByPrimaryKey(person.getId());
        if (deposit==null){
            //缴纳押金

            //支付环节
            try{

                //成功存数据库
                depositMapper.insert(deposit);
            }catch (Exception e){
                e.printStackTrace();
            }

        }
        //判断商品是否被购买
        if (goodsInfo.getStatus() != 1) {
            //被购买返回false
            return "noGoods";
        }
        //获取id
        long id = goodsInfo.getgId();
        //判断是否被上锁 上锁返回false
        if (ResourceLock.tryLock(id)) {
            //上锁
            ResourceLock.accquireWrite(id);
            try {
                System.out.println("等待付款");
                Thread.sleep(30000);
                System.out.println("付款成功");
                goodsInfo.setStatus(0);
                //更改状态
                goodsInfoMapper.updateByPrimaryKey(goodsInfo);
                //解锁
                ResourceLock.releaseWrite(id);
                //支付成功 返回true
                return "success";
            } finally {
                //如果异常 解锁
                ResourceLock.releaseWrite(id);
                return "noseckillGoods";
            }
        }
        return "noseckillGoods";
    }

}

