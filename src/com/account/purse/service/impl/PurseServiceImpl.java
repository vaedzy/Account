package com.account.purse.service.impl;

import com.account.bean.Purse;
import com.account.mapper.PurseMapper;
import com.account.purse.service.PurseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class PurseServiceImpl implements PurseService {
    @Autowired
    private PurseMapper purseMapper;

    @Override
    public String insertPurse(long id) {
        Purse purse = new Purse();
        purse.setPersonId(id);
        int i = purseMapper.insert(purse);
        if (i==1){
            return "success";
        }
       return "error";
    }

    @Override
    public Double selectMoney(long id) {
       Purse purse =  purseMapper.getMoneyByPrimaryKey(id);
        double money = purse.getMoney();
        return money;
    }

    @Override
    public Double rechargeMoenry(long id,double money) {
        //支付
        return null;
    }

}
