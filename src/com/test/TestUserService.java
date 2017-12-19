package com.test;

import com.account.bean.User;
import com.account.login.service.UserService;
import com.account.login.service.impl.UserServiceImpl;

public class TestUserService {
    public static void main(String []args)  {
        UserService userService = new UserServiceImpl();
        User user = new User("13241997744");
        user =  userService.findUser(user);
       System.out.println(user.getId());
    }
}
