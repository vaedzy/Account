package com.account.show.controller;


import com.account.bean.GoodsInfo;

import com.account.show.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
public class CommodityControler {
    @Autowired
    private CommodityService commodityService;


    /**
     * 查询商品详情
     * @param gId
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping("show.do")
    public ModelAndView showCommodity(@RequestParam("gId")long gId, HttpServletRequest request){
        //返回到商品详情页 根据id
        commodityService.getGoogsById(gId,request);
        //进入goodsShow页面
        return new ModelAndView("goodsShow");
    }
    /**
     * 商品的发布 判断用户是否登陆
     */
    @RequestMapping("addGoods")
    public ModelAndView loginAddGoods(HttpServletRequest request, HttpSession httpSession){
        if (httpSession.getAttribute("user")==null){
            return new ModelAndView("redirect:/toLogin");
        }

        Boolean realName = commodityService.RealName(httpSession);
        if (realName) {
            return new ModelAndView("add");
        }
        return new ModelAndView("mycenter");
    }


    /**
     * 更改上架信息
     * @param goodsInfo
     * @return
     */
    @ResponseBody
    @RequestMapping("deleteGoods")
    public String deleteGoods(GoodsInfo goodsInfo){
        int delete = commodityService.deleteByPrimaryKey(goodsInfo);
        if (delete>0) {
            return "success";
        }
        return "404";
    }

    /**
     * 确认登陆 发布后存数据库操作
     * @param goodsInfo
     * @param file
     * @param request
     * @return
     * @throws Exception
     */

    @RequestMapping("addGoods.do")
    private ModelAndView addGoods(GoodsInfo goodsInfo, @RequestParam(value="file",required=false) MultipartFile[] file,
                              HttpServletRequest request)throws Exception{
       Boolean insertOk = commodityService.insert(goodsInfo,file,request);
       if (insertOk){
           return new ModelAndView("");
       }
       return new ModelAndView("");
    }


        @ResponseBody
        @RequestMapping("Seckill")
        public String seckillGoods(@RequestParam("gId")long gId, HttpSession httpSession)throws InterruptedException {
            //判断用户是否登录
            if (httpSession.getAttribute("user")==null){
               return "noLogin";
            }
            String commod = commodityService.seckillGoods(gId,httpSession);
            return commod;
        }
}
