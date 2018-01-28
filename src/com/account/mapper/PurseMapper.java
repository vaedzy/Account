package com.account.mapper;

import com.account.bean.Purse;

public interface PurseMapper {
    int updateMoney(Purse record);
    int insert(Purse record);
    Purse getMoneyByPrimaryKey(long personId);
    int rechargeMoenry(long id);
}
