package com.account.realname.controller;

import com.account.realname.service.RealNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class RealNameController {
    @Autowired
    private RealNameService realNameService;


}
