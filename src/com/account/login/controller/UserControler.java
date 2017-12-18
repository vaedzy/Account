package com.account.login.controller;

import com.account.login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserControler {
    @Autowired
    private UserService userService;

}
