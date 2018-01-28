package com.account.purse.service;

public interface PurseService {
    String insertPurse(long id);
    /**
     * 查询余额
     * @param id
     * @return
     */
    Double selectMoney(long id);

    /**
     *
     * @param id
     * @param money
     * @return
     */
    Double rechargeMoenry(long id,double money);
}
