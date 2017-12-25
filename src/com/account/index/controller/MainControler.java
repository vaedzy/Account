package com.account.index.controller;

import com.account.bean.App;
import com.account.index.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class MainControler {
    @Autowired
   private MainService mainService;

    /**
     * 主导航点击 a-z
     */
    @ResponseBody
    @RequestMapping("mainNav")
    public String mainNav(@RequestParam("mainNav")String mainNav,HttpServletRequest request ){
        List<App> appList = mainService.appList(mainNav);
        //是否需要判断传来的数据是a-z中的哪一个
        //将查找到的数据存入session中 从页面获取
       request.getSession().setAttribute("appList",appList);
    return "success";
    }
}
