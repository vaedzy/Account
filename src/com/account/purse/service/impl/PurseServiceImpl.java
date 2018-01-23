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
    public String selectMoney(long id) {
       Purse purse =  purseMapper.getMoneyByPrimaryKey(id);

        return "";
    }
}
