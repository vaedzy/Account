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
     * @param mainNav
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping("mainNav")
    public List<App> mainNav(@RequestParam("mainNav")String mainNav,HttpServletRequest request){
        List<App> appList = mainService.appList(mainNav);
        return appList;
    }

    /**
     * 搜索框
     * @param search
     * @param request
     * @param session
     * @return
     */
    @RequestMapping("souApp")
    public ModelAndView souApp(@RequestParam("search")String search, HttpServletRequest request, HttpSession session){
        //判断传入的是否为空
        if (search==null||search.equals("")){
            //返回首页
            return new ModelAndView("redirect:/index.jsp");
        }
        Boolean searchOk = mainService.getAppName(search,request);
        if (searchOk){
            return new ModelAndView("show");
        }
        return new ModelAndView("redirect:/index.jsp");
    }

    /**
     * 查询app区下的商品
     * @param quName
     * @return
     */
    @ResponseBody
    @RequestMapping("souAppQu")
    public List<GoodsInfo> souAppQu(@RequestParam("quName")String quName){
       List<GoodsInfo> goodsInfoList = mainService.getAppQuGoods(quName);
        return goodsInfoList;
    }

    /**
     * 根据id查询所有区
     * @param AppId
     * @return
     */
    @ResponseBody
    @RequestMapping("searchTypeAndAppName")
    public List<AppQu> searchTypeAndAppName(@RequestParam("AppId")long AppId){
        //根据id查询区
        List<AppQu> appQuList = mainService.getAppQuList(AppId);
       return appQuList;
    }

}
