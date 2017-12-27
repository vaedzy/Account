package com.account.mapper;

import com.account.bean.AccountOrder;

import java.util.List;

public interface AccountOrderMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AccountOrder record);

    AccountOrder selectByPrimaryKey(Long id);

    List<AccountOrder> selectAll();

    int updateByPrimaryKey(AccountOrder record);
}