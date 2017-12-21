package com.account.login.controller;

import com.account.bean.User;
import com.account.common.utils.MobileMessageCheck;
import com.account.common.utils.PhoneFormatCheckUtils;
import com.account.login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class UserControler {
    @Autowired
    private UserService userService;
    private String Ccode ="1234"; //用于存储验证码
    private String Tphone; //用于获取验证码的手机号


    /*
     获取验证码
     */
    @RequestMapping("/getCode")
    public @ResponseBody boolean getCode(@RequestParam("phone")String phone){
        //发送短信
        try {
            if (PhoneFormatCheckUtils.isChinaPhoneLegal(phone)){
                Tphone = phone;
                Ccode = MobileMessageCheck.checkMsg(phone);
                    return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
    /*
    验证手机号与验证码
     */
    @RequestMapping("/login")
    public @ResponseBody  String login(@RequestParam("phone")String phone, String code, HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
       //判断手机号是否为空
        if (phone == null || phone.equals("")){
            return "errorPhone";
        }
        //判断验证码是否为空
        if (code == null || code.equals("")){
            return "errorCode";
        }
        //判断传入的手机号是不是刚才获取验证码的手机号
        if (phone.equals(Tphone)){
            //是
            if (Ccode.equals(code)){
                //是
               User user = userService.findUser(new User(phone));
               if (user.getUsername()==null || user.getUsername().equals("")){
                   //那么这个人没有注册 是新用户
                   /*
                   写入一个session
                    */
                   HttpSession session = request.getSession();
                   session.setAttribute("success","success");
                   return "register";
               }
               //返回user对象
                Cookie cookie = new Cookie("user",user.getPhone().toString());
                cookie.setMaxAge(24*60*60);
                cookie.setPath("/");
                response.addCookie(cookie);
                HttpSession session = request.getSession();
                session.setAttribute("user",user);
                return "login";
            }else{
                //不是 ? 是否让用户重新获取或者是重新发送
                return "errorCode";
            }
        }else{
            return "errorPhone";
        }
    }
    /*
    进入注册页面
     */
    @RequestMapping("/register")
    public ModelAndView toRegister(HttpServletRequest request){
        HttpSession httpSession = request.getSession();
            String success= (String)httpSession.getAttribute("success");
            if (success==null){
                return new ModelAndView("redirect:/index.jsp");
            }
            httpSession.removeAttribute("success");
            return new ModelAndView("register");

    }
    /*
    注册流程
     */
    @RequestMapping("/register.do")
    public @ResponseBody String register(@RequestParam("username")String username,String code,HttpServletRequest request,HttpServletResponse response){
        //判断手机号是否为空
        if (username == null || username.equals("")){
            return "errorUser";
        }
        //判断我同意是否为空
        if (code == null || code.equals("")){
            return "errorCode";
        }
        String cCode ="我同意";
        if (code.equals(cCode)) {
            //是我同意
            User user = userService.registerUser(new User(Tphone));
            user.setUsername(username);
            userService.findUser(user);
            //返回user对象
            Cookie cookie = new Cookie("user",user.getId().toString());
            cookie.setMaxAge(24*60*60);
            cookie.setPath("/");
            response.addCookie(cookie);
            HttpSession session = request.getSession();
            session.setAttribute("user",user);
            return "login";
        }else{
           return "errorCode";
        }
    }
}
