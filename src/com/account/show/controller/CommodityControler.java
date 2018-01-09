package com.account.show.controller;

import com.account.bean.Attachment;
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

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


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
        return new ModelAndView("add");

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
    private String addGoods(GoodsInfo goodsInfo, @RequestParam(value="file",required=false) MultipartFile[] file,
                              HttpServletRequest request)throws Exception{

        if (file!=null) {
            //获得物理路径webapp所在路径
            String pathRoot = request.getSession().getServletContext().getRealPath("");
            String path = "";
            int i =1;
            for (MultipartFile mf : file) {
                System.out.println(mf.getOriginalFilename());
                if (!mf.isEmpty()) {
                    System.out.println(i);
                    //生成uuid作为文件名称
                    String uuid = UUID.randomUUID().toString().replaceAll("-", "");
                    //获得文件类型（可以判断如果不是图片，禁止上传）
                    String contentType = mf.getContentType();
                    //获得文件后缀名称
                    String imageName = contentType.substring(contentType.indexOf("/") + 1);
                    path = "/static/images/" + uuid + "." + imageName;
                    //如果没有该目录则新建目录
                    if (!new File(pathRoot+ "/static/images/").isDirectory()) {
                        new File(pathRoot+ "/static/images/").mkdirs();
                    }
                    mf.transferTo(new File(pathRoot + path));

                    if (i==1){
                        goodsInfo.setGphotourl1(path);
                        i++;
                        System.out.println(i);
                    }
                    if (i==2){
                        goodsInfo.setGphotourl2(path);
                        i++;
                        System.out.println(i);
                    }
                    if (i==3){
                        goodsInfo.setGphotourl3(path);
                        i++;
                        System.out.println(i);
                    }
                    if (i==4){
                        goodsInfo.setGphotourl4(path);
                        i++;
                        System.out.println(i);
                    }
                    if (i==5){
                        goodsInfo.setGphotourl5(path);
                        i++;
                        System.out.println(i);
                    }
                    if (i==6){
                        goodsInfo.setGphotourl6(path);
                        i++;
                        System.out.println(i);
                    }
                    if (i==7){
                        goodsInfo.setGphotourl7(path);
                        i++;
                        System.out.println(i);
                    }
                    if (i==8){
                        goodsInfo.setGphotourl8(path);
                        i++;
                        System.out.println(i);
                    }
                    if (i==9){
                        goodsInfo.setGphotourl9(path);
                        i++;
                        System.out.println(i);
                    }
                    if (i==10){
                        goodsInfo.setGphotourl10(path);
                        System.out.println(i);
                    }
                }
            }
            System.out.println(goodsInfo.getGphotourl2());
            commodityService.insert(goodsInfo);
        }

        return "success";
    }


}
