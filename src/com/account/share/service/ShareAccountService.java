package com.account.share.service;

import com.account.bean.AppDeveloper;

import java.util.List;


public interface ShareAccountService {
    /**
     * 预留接口 留给厂商查看被租借的账号的账号与密码 (监控账号)
     * @param appDeveloper
     * @return
     */
     AppDeveloper ControlAccount (String appDeveloper);

    /**
     * 加入被下单的账号
     * @param appDeveloper
     */
    void insertAccount (AppDeveloper appDeveloper);

    /**
     * 预留接口 解锁
     * @param id
     */
    void deleteAccount (long id);

    /**
     * 预留接口 查询所有
     * @return
     */
    List<AppDeveloper> appDeveloperList();
}
