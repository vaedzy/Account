package com.account.deposit.service.impl;

import com.account.bean.Deposit;
import com.account.deposit.service.DepositService;
import com.account.mapper.DepositMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class DepositServiceImpl implements DepositService{
    @Autowired
    private DepositMapper depositMapper;

    /**
     * 查询押金缴纳情况
     * @param id
     * @return
     */
    @Override
    public String selectDeposit(long id) {

        Deposit deposit = depositMapper.getDepositByPrimaryKey(id);
        if (deposit.getpIsRegistered().equals("y")||deposit.getpIsRegistered()=="y"){
            return "y";
        }
        return "n";
    }

    /**
     * 缴纳押金
     * @param id
     * @return
     */
    @Override
    public String insertDeposit(long id) {


        return null;
    }

    /**
     * 退订押金
     * @param id
     * @return
     */
    @Override
    public String unsubscribeDeposit(long id) {
        return null;
    }

}
