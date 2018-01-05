package com.account.show.controller;

import com.account.bean.GoodsInfo;
import com.account.show.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
public class CommodityControler {
    @Autowired
    private CommodityService commodityService;
    /**
     * 前台点击商品后查询商品信息后返回商品详情
     */
    @ResponseBody
    @RequestMapping("show.do")
    public ModelAndView showCommodity(@RequestParam("gId")long gId, HttpServletRequest request){
        //返回到商品详情页 根据id
        GoodsInfo goodsInfo = commodityService.getGoogsById(gId);

        System.out.println( goodsInfo.getgName());
        System.out.println(goodsInfo.getRemark());
        request.setAttribute("goodsInfo",goodsInfo);
        return new ModelAndView("test1");
    }
    /**
     * 商品的发布 判断用户是否登陆
     */
    @RequestMapping("addGoods")
    public ModelAndView loginAddGoods(HttpServletRequest request, HttpSession httpSession){
        if (httpSession.getAttribute("user")==null){

            return new ModelAndView("redirect:/toLogin");
        }
        return new ModelAndView("addGoods");

    }

    /**
     *  确认登陆 发布后存数据库操作
     * @return
     */
    @ResponseBody
    @RequestMapping("addGoods.do")
    public String addGoods(GoodsInfo goodsInfo,HttpSession httpSession,HttpServletRequest request){
       goodsInfo.setGphotourl1("");

        return "success";
    }

    @ResponseBody
    @RequestMapping("deleteGoods")
    public String deleteGoods(GoodsInfo goodsInfo){
        int delete = commodityService.deleteByPrimaryKey(goodsInfo);
        if (delete>0) {
            return "success";
        }
        return "404";
    }

}
