package com.account.index.controller;

import com.account.bean.App;
import com.account.index.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
    public List<App> mainNav(@RequestParam("mainNav")String mainNav,HttpServletRequest request){
        System.out.println(mainNav);
        List<App> appList = mainService.appList(mainNav);
        //是否需要判断传来的数据是a-z中的哪一个
        //将查找到的数据存入session中 从页面获取
       request.getSession().setAttribute("appList",appList);
       return appList;
    }

    /**
     * 搜索框
     */
    @RequestMapping("souApp")
    public ModelAndView souApp(@RequestParam("search")String search, HttpServletRequest request, HttpSession session){
        //判断传入的是否为空
        if (search==null||search.equals("")){
            //返回首页
            return new ModelAndView("redirect:/index.jsp");
        }
        //如果不是空
        //查询是否存在这个应用

        //如果存在
        if(appDetailsList!=null && !appDetailsList.isEmpty()){
            //存入应用表数据
            session.setAttribute("appDetailsList",appDetailsList);
            //存储真正的应用名
            String appname = null;
            //循环遍历出应用名
            for (AppDetails app : appDetailsList){
                appname = app.getAppName();
            }
            //根据应用名称获取商品
            List<Commodity> commodityList = mainService.AllCommodity(appname);
            if (commodityList!=null && !commodityList.isEmpty()){
                //不为空 有商品
                session.setAttribute("commodityList",commodityList);
                return new ModelAndView("");
            }else {
                return new ModelAndView("");
            }
        }else{
           //不存在

            return new ModelAndView("");
        }

        return new ModelAndView("");
    }
    /**
     * 精准的应用名 来源于主导航
     */
    @RequestMapping("preciseApp")
    public ModelAndView preciseApp(@RequestParam("AppName")String AppName){
        System.out.println(AppName);
        return new ModelAndView();
    }
}
