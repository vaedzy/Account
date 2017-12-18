package com.account.common.dao;

import com.account.bean.User;

public interface UserDao {
    public User findUser(User user);
    public void saveUser(User user);
}
