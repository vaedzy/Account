package com.account.index.controller;

import com.account.index.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainControler {
//    @Autowired
//   private MainService mainService;

    /**
     * 主导航点击 a-z
     */
    @ResponseBody
    @RequestMapping("mainNav")
    public String mainNav(@RequestParam("a")String a){
    return "null";
    }
}
