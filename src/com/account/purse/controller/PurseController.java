package com.account.purse.controller;

import com.account.purse.service.PurseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PurseController {
    @Autowired
    private PurseService purseService;

    /**
     * 查询余额
     * @return
     */
    @ResponseBody
    @RequestMapping("selectMoney")
    public String selectMoney(@RequestParam("id") long id){
       String money =  purseService.selectMoney(id);
        return money;
    }

    @RequestMapping("recharge")
    public String rechargePurse(@RequestParam("id")long id,@RequestParam("money") double money){
        return "";
    }
}
