package com.account.deposit.service;

import javax.servlet.http.HttpSession;

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
}
