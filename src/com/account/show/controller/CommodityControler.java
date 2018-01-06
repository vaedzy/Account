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
    private String fildUpload(GoodsInfo goodsInfo, @RequestParam(value="file",required=false) MultipartFile[] file,
                              HttpServletRequest request)throws Exception{
        if (file!=null) {
            //获得物理路径webapp所在路径
            String pathRoot = request.getSession().getServletContext().getRealPath("");
            String path = "";
            List<String> listImagePath = new ArrayList<>();
            for (MultipartFile mf : file) {
                if (!mf.isEmpty()) {
                    //生成uuid作为文件名称
                    String uuid = UUID.randomUUID().toString().replaceAll("-", "");
                    //获得文件类型（可以判断如果不是图片，禁止上传）
                    String contentType = mf.getContentType();
                    //获得文件后缀名称
                    String imageName = contentType.substring(contentType.indexOf("/") + 1);
                    path = "/static/images/" + uuid + "." + imageName;
                    mf.transferTo(new File(pathRoot + path));
                    listImagePath.add(path);
                    System.out.println(path);
                }
            }
        }
    System.out.println(goodsInfo.getGphotourl1());

        return "success";
    }
}
