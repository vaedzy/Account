package com.account.login.controller;

import com.account.bean.Person;
import com.account.bean.RealName;
import com.account.common.base.BaseController;
import com.account.common.utils.MobileMessageCheck;
import com.account.common.utils.PhoneFormatCheckUtils;
import com.account.common.utils.StringUtil;
import com.account.login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class UserControler extends BaseController {
    @Autowired
    private UserService userService;
    /**
     * 用于存储验证码
     */
    private String Ccode;
    /**
     * 用于获取验证码的手机号
     */
    private String Tphone;

    /**
     * 获取登陆前的url
     */
    @RequestMapping("/toLogin")
    public ModelAndView toLogin(HttpServletRequest request, HttpSession httpSession) {

        //获取session
        HttpSession session = request.getSession();
        //获取访问链接
        String url = request.getHeader("Referer");
        //把url放到session
        session.setAttribute("redirectUrl", url);
        //如果传入的是toLogin
        return new ModelAndView("login");

    }

    /**
     * 获取验证码
     */
    @ResponseBody
    @RequestMapping("/getCode")
    public boolean getCode(@RequestParam("phone") String phone) {
        //发送短信
        try {
            //判断是否是个合法的手机号
            if (PhoneFormatCheckUtils.isChinaPhoneLegal(phone)) {
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

    /**
     * 点击登录时：
     * 验证手机号与验证码
     */
    @ResponseBody
    @RequestMapping("/login.do")
    public String login(@RequestParam("phone") String phone, String code, HttpServletRequest request,
                        HttpServletResponse response) throws ServletException, IOException {
        //判断手机号是否为空
        if (phone == null || phone.equals("")) {
            return "errorUser";
        }
        //判断验证码是否为空
        if (code == null || code.equals("")) {
            //让login.jsp页面中的code框清空
            return "errorCode";
        }
        //判断传入的手机号是不是刚才获取验证码的手机号
        if (phone.equals(Tphone)) {
            //判断验证码是否正确
            if (Ccode.equals(code)) {
                //执行查询操作
                Person user = userService.getUser(phone, request);
                //如果username为空 则跳转到注册
                if (user.getpFullname() == null || user.getpFullname().equals("")) {
                    //那么这个人没有注册 是新用户 设置一个session 这个session防止了用户访问到注册页面
                    HttpSession session = request.getSession();
                    session.setAttribute("success", "success");
                    return "register";
                }
                //返回user对象 设置cookie与session
                Cookie cookie = new Cookie("user", user.getpPhone().toString());
                //一天的cookie有效期
                cookie.setMaxAge(24 * 60 * 60);
                //cookie的作用域
                cookie.setPath("/");
                //发送cookie
                response.addCookie(cookie);
                //设置session
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                return "login";
            } else {
                //不是 ? 是否让用户重新获取或者是重新发送
                return "errorCode";
            }
        } else {
            return "errorPhone";
        }
    }


    /*
     进入注册页面
      */
    @RequestMapping("/register")
    public ModelAndView toRegister(HttpServletRequest request) {
        //获取session
        HttpSession httpSession = request.getSession();
        //获取session
        String success = (String) httpSession.getAttribute("success");
        //如果session为空 说明是恶意进入 返回首页
        if (success == null) {
            return new ModelAndView("redirect:/index.jsp");
        }
        //进入注册页面
        return new ModelAndView("register");

    }

    /**
     * 注册流程
     */
    @ResponseBody
    @RequestMapping("/register.do")
    public String register(Person entity, HttpServletRequest request, HttpServletResponse response) {
        //判断用户名是否为空
        if (StringUtil.isBlank(entity.getpFullname())) {
            return "errorUser";
        }
        //判断我同意是否为空
        if (StringUtil.isBlank(entity.getpDevelop01())) {
            return "errorCode";
        }
        String cCode = "我同意";
        if (cCode.equals(entity.getpDevelop01())) {
            //是我同意 执行注册方法 根据phone查询设置username
            entity.setpPhone(Tphone);
            //操作数据库
            Person person = userService.updatePerson(entity, request);
            //返回user对象
            Cookie cookie = new Cookie("user", entity.getpPhone());
            //设置cookie一天时间
            cookie.setMaxAge(24 * 60 * 60);
            //设置cookie的作用域
            cookie.setPath("/");
            //发送cookie
            response.addCookie(cookie);
            //获取session
            HttpSession session = request.getSession();
            //发送session
            session.setAttribute("user", entity);
            return "login";
        } else {
            return "errorCode";
        }
    }

    /**
     * 登陆后返回之前的页面
     */
    @RequestMapping("formTag")
    public ModelAndView formTag(HttpSession httpSession) {
        //登陆的验证通过后,在从session里获取前画面的url
        String url = (String) httpSession.getAttribute("redirectUrl");
        //跳转回去
        return new ModelAndView("redirect:" + url);
    }

    /**
     * 退出登陆
     */
    @RequestMapping("logout")
    public ModelAndView logOut(HttpSession httpSession) {
        //清除user的session
        httpSession.removeAttribute("user");
        //跳转到首页
        return new ModelAndView("redirect:/index.jsp");
    }

    @ResponseBody
    @RequestMapping("realName")
    public String realName(RealName realName ,@RequestParam(value="file",required=false) MultipartFile[] file,
                           HttpServletRequest request)throws Exception{
       String ok= userService.insertRealName(realName,file,request);
       return ok;
    }

    
}
