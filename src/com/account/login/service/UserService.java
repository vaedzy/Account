package com.account.login.service;

import com.account.bean.User;

public interface UserService {
    User findUser(User user);
    User registerUser(User user);
}
