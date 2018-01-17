package com.account.deposit.controller;

import com.account.deposit.service.DepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;


@Controller
public class DepositController {
    @Autowired
    private DepositService depositService;

    /**
     * 查询押金缴纳情况
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("selectDeposit")
    public String selectDeposit(@RequestParam("id")long id){

       String selectDepositResult = depositService.selectDeposit(id);
       return selectDepositResult;
    }

}
