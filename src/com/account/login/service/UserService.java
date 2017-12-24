package com.account.login.service;

import com.account.bean.Person;

public interface UserService {

    /**
     * 通过手机号查找人员
     * @param phone
     * @return
     */
   Person  getUser(String phone);

    /**
     * 更新人员信息
     * @param user
     * @return
     */
    Person updatePerson(Person user);

}
