package com.account.purse.service;

public interface PurseService {
    /**
     * 查询余额
     * @param id
     * @return
     */
    String selectMoney(long id);
}
