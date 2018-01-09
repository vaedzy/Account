package com.account.index.controller;

import com.account.bean.App;
import com.account.bean.AppName;
import com.account.bean.AppQu;
import com.account.bean.GoodsInfo;
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
        List<AppName> appNameList = mainService.getAppName(search);
        //如果存在
        if(appNameList!=null && !appNameList.isEmpty()){
            //存入应用表数据
          //  session.setAttribute("appNameList",appNameList);
            request.setAttribute("appNameList",appNameList);
            //给appid赋值
            long AppId = -1;
            //循环遍历出应用名
            for (AppName app : appNameList){
                //app的id 用这个去查区服以及商品
                AppId = app.getAppId();
            }
            List<AppQu> appQuList = mainService.getAppQu(AppId);
           // session.setAttribute("appQuList",appQuList);
            request.setAttribute("appQuList",appQuList);
            List<GoodsInfo> goodsInfoList = mainService.getGoodsInfo(AppId);
           // session.setAttribute("goodsInfoList",goodsInfoList);
            request.setAttribute("goodsInfoList",goodsInfoList);
            return new ModelAndView("show");
        }else{
           //不存在
            return new ModelAndView("redirect:/index.jsp");
        }
    }

    /**
     * 查询app区下的商品
     */
    @ResponseBody
    @RequestMapping("souAppQu")
    public List<GoodsInfo> souAppQu(@RequestParam("quName")String quName,HttpServletRequest request){
        List<AppQu> appQuList = mainService.getAppQuName(quName);
        long quId = -1;
        for (AppQu appQu : appQuList){
            quId = appQu.getQuId();
        }
        List<GoodsInfo> goodsInfoList = mainService.getGoodsInfoQu(quId);
        return goodsInfoList;
    }

    /**
     * 精准的应用名 来源于主导航
     */
    @RequestMapping("preciseApp")
    public ModelAndView preciseApp(@RequestParam("AppName")String AppName){
        System.out.println(AppName);
        return new ModelAndView();
    }

    @ResponseBody
    @RequestMapping("searchTypeAndAppName")
    public List<AppQu> searchTypeAndAppName(@RequestParam("AppId")long AppId,HttpServletRequest request){
        //根据id查询区
        List<AppQu> appQuList = mainService.getAppQu(AppId);
        if (appQuList !=null && !appQuList.isEmpty()){
            return appQuList;
        }
       return null;
    }
}
