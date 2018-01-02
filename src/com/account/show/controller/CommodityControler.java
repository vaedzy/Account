package com.account.show.controller;

import com.account.bean.GoodsInfo;
import com.account.show.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CommodityControler {
    @Autowired
    private CommodityService commodityService;
    /**
     * 前台点击商品后查询商品信息后返回商品详情
     */
    @RequestMapping("show.do")
    public ModelAndView showCommodity(@RequestParam("gId")long gId, HttpServletRequest request){
        //返回到商品详情页 根据id
        GoodsInfo goodsInfo = commodityService.getGoogsById(gId);
        request.setAttribute("goodsInfo",goodsInfo);
        return new ModelAndView("");
    }
    /**
     * 商品的发布
     */
}
