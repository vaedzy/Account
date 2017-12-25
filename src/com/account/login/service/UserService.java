package com.account.login.service;

import com.account.bean.Person;

import javax.servlet.http.HttpServletRequest;

public interface UserService {

    /**
     * 通过手机号查找人员
     * @param phone
     * @param request
     * @return
     */
   Person getUser(String phone, HttpServletRequest request);

    /**
     * 更新人员信息
     * @param user
     * @param request
     * @return
     */
    Person updatePerson(Person user,HttpServletRequest request);

}
