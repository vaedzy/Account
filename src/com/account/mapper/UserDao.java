package com.account.mapper;

import com.account.bean.User;



public interface UserDao {
     User findUser(User user);
     void saveUser(User user);
}
