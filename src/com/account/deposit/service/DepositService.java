package com.account.deposit.service;



public interface DepositService {
    /**
     * 查询押金缴纳情况
     * @param id
     * @return
     */
    String selectDeposit(long id);

    /**
     * 缴纳押金
     * @param id
     * @return
     */
    String insertDeposit(long id);

    /**
     * 退订押金
     * @param id
     * @return
     */
    String unsubscribeDeposit(long id);
}
