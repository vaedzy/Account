package com.account.mapper;

import com.account.bean.Deposit;

public interface DepositMapper {
    int insert (Deposit record);
    Deposit getDepositByPrimaryKey(Long id);
}
