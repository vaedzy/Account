package com.account.login.controller;

import com.account.bean.User;
import com.account.common.utils.MobileMessageCheck;
import com.account.login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
public class UserControler {
    @Autowired
    private UserService userService;
    private String Ccode; //用于存储验证码
    private String Tphone; //用于获取验证码的手机号
    /*
     获取验证码
     */
    @RequestMapping("getCode")
    public void getCode(@RequestParam("phone")String phone){
        //发送短信
        try {
            Tphone = phone;
            Ccode = MobileMessageCheck.checkMsg(phone);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /*
    验证手机号与验证码
     */
    @RequestMapping("/login")
    public String login(@RequestParam("phone")String phone,String code){
       //判断手机号是否为空
        if (phone == null || phone.equals("")){
            return "error";
        }
        //判断验证码是否为空
        if (code == null || code.equals("")){
            return "error";
        }
        //判断传入的手机号是不是刚才获取验证码的手机号
        if (phone == Tphone || phone.equals(Tphone)){
            //是
            if (Ccode==code || Ccode.equals(code)){
                //是
                userService.findUser(new User(phone));
            }else{
                //不是 ? 是否让用户重新获取或者是重新发送

            }
        }
        return "noLogin";
    }

}
