package com.account.login.controller;

import com.account.bean.Person;
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
    private String Ccode ; //用于存储验证码
    private String Tphone; //用于获取验证码的手机号

    @RequestMapping("/toLogin")
    public ModelAndView toLogin(HttpServletRequest request,HttpSession httpSession){

        //获取session
        HttpSession session = request.getSession();
        //获取访问链接
        String url = request.getHeader("Referer");
        session.setAttribute("redirectUrl", url);//把url放到session
        //如果传入的是toLogin
        return new ModelAndView("login");

    }
    /*
     获取验证码
     */

    @ResponseBody
    @RequestMapping("/getCode")
    public  boolean getCode(@RequestParam("phone")String phone){
        //发送短信
        try {
            //判断是否是个合法的手机号
            if (PhoneFormatCheckUtils.isChinaPhoneLegal(phone)){
                //传进来的phone赋值给缓存
                Tphone = phone;
                //获取发送验证码并赋值给缓存
                Ccode = MobileMessageCheck.checkMsg(phone);
                //让login.jsp页面中的phone框变绿
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //让login.jsp页面中的phone框变变红
        return false;
    }

    /*
    验证手机号与验证码
     */
    @ResponseBody
    @RequestMapping("/login.do")
    public  String login(@RequestParam("phone")String phone, String code, HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        //保存连接
        String url = request.getHeader("Referer");//获取上个页面的url
       //判断手机号是否为空
        if (phone == null || phone.equals("")){
            //让login.jsp页面中的phone框变红
            return "errorPhone";
        }
        //判断验证码是否为空
        if (code == null || code.equals("")){
            //让login.jsp页面中的code框清空
            return "errorCode";
        }
        //判断传入的手机号是不是刚才获取验证码的手机号
        if (phone.equals(Tphone)){
            //判断验证码是否正确
            if (Ccode.equals(code)){
                //执行查询操作
               Person user = userService.getUser(phone);
               //如果username为空 则跳转到注册
               if (user.getUsername()==null || user.getUsername().equals("")){
                   //那么这个人没有注册 是新用户 设置一个session 这个session防止了用户访问到注册页面
                   HttpSession session = request.getSession();
                   session.setAttribute("success","success");
                   return "register";
               }
               //返回user对象 设置cookie与session
                Cookie cookie = new Cookie("user",user.getPhone().toString());
               //一天的cookie有效期
                cookie.setMaxAge(24*60*60);
                //cookie的作用域
                cookie.setPath("/");
                //发送cookie
                response.addCookie(cookie);
                //设置session
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
        //获取session
        HttpSession httpSession = request.getSession();
        //获取session
            String success= (String)httpSession.getAttribute("success");
            //如果session为空 说明是恶意进入 返回首页
            if (success==null){
                return new ModelAndView("redirect:/index.jsp");
            }
            //清除名字为success的session
            httpSession.removeAttribute("success");
            //进入注册页面
            return new ModelAndView("register");

    }
    /*
    注册流程
     */
    @RequestMapping("/register.do")
    public @ResponseBody String register(@RequestParam("username")String username,String code,HttpServletRequest request,HttpServletResponse response){
        //判断用户名是否为空
        if (username == null || username.equals("")){
            return "errorUser";
        }
        //判断我同意是否为空
        if (code == null || code.equals("")){
            return "errorCode";
        }
        String cCode ="我同意";
        if (code.equals(cCode)) {
            //是我同意 执行注册方法 根据phone查询设置username
            Person user = userService.getUser(Tphone);
            //保存username
            user.setUsername(username);
            //操作数据库
            userService.updatePerson(user);
            //返回user对象
            Cookie cookie = new Cookie("user",user.getPhone().toString());
            //设置cookie一天时间
            cookie.setMaxAge(24*60*60);
            //设置cookie的作用域
            cookie.setPath("/");
            //发送cookie
            response.addCookie(cookie);
            //获取session
            HttpSession session = request.getSession();
            //发送session
            session.setAttribute("user",user);
            return "login";
        }else{
           return "errorCode";
        }
    }

    @RequestMapping("formTag")
    public ModelAndView formTag(HttpSession httpSession){
        //登陆的验证通过后,在从session里获取前画面的url
        String url = (String) httpSession.getAttribute("redirectUrl");
        //跳转回去
        return new ModelAndView("redirect:"+url);
    }
    @RequestMapping("logout")
    public ModelAndView logOut(HttpSession httpSession){
        System.out.println("进来了");
        //清除user的session
       httpSession.removeAttribute("user");
        //跳转到首页
        return new ModelAndView("redirect:/index.jsp");
    }
}
