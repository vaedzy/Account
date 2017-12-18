package com.account.login.service.impl;

import com.account.bean.User;
import com.account.common.dao.UserDao;
import com.account.login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;

    public User findUser(User user){
        User newuser=userDao.findUser(user);
        if(newuser!=null){
            return newuser;
        }
        userDao.saveUser(user);
        return userDao.findUser(user);
    }
}