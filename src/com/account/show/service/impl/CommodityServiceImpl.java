package com.account.show.service.impl;

import com.account.bean.*;

import com.account.common.utils.ResourceLock;
import com.account.mapper.*;
import com.account.show.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Service("commodityService")
@Transactional(rollbackFor = Exception.class)
public class CommodityServiceImpl implements CommodityService{
    @Autowired
    private GoodsInfoMapper goodsInfoMapper;
    @Autowired
    private RealNameMapper realNameMapper;
    @Autowired
    private DepositMapper depositMapper;
    @Autowired
    private AppNameMapper appNameMapper;
    @Autowired
    private AppQuMapper appQuMapper;

    /**
     * 根据商品id查询商品详情
     * @param gId
     * @return
     */
    @Override
    public void getGoogsById(long gId, HttpServletRequest request) {
        //查询商品
        GoodsInfo goodsInfo = goodsInfoMapper.getGoodsById(gId);
        //查询appName
        AppName appName =appNameMapper.getAppNameById(goodsInfo.getAppId());
        //查询区名称
        String quName = appQuMapper.getAppQuNameByQuId(goodsInfo.getQuId());
        System.out.println(quName);
        request.setAttribute("appName",appName.getAppName());
        request.setAttribute("quName",quName);
        request.setAttribute("goodsInfo",goodsInfo);
    }

    @Override
    public int updateByPrimaryKey(GoodsInfo record) {
        int update = goodsInfoMapper.updateByPrimaryKey(record);
        return update;
    }

    @Override
    public Boolean insert(GoodsInfo record, MultipartFile[] file, HttpServletRequest request)throws Exception {
        List<String> fileTypes = new ArrayList<String>();
        fileTypes.add("jpg");
        fileTypes.add("jpeg");
        fileTypes.add("bmp");
        fileTypes.add("gif");
        fileTypes.add("png");
        if (file!=null) {
            //获得物理路径webapp所在路径
            String pathRoot = request.getSession().getServletContext().getRealPath("");
            String path = "";
            int i = 1;
            for (MultipartFile mf : file) {
                if (!mf.isEmpty()) {
                    //生成uuid作为文件名称
                    String uuid = UUID.randomUUID().toString().replaceAll("-", "");
                    String fileName = mf.getOriginalFilename();
                    fileName.substring(fileName.lastIndexOf("."));
                    //获得文件后缀名称
                    String imageName = fileName.substring(fileName.lastIndexOf(".")+1,fileName.length());
                    imageName = imageName.toLowerCase();
                    if (fileTypes.contains(imageName)) {
                        path = "/static/images/" + uuid + "." + imageName;
                        //如果没有该目录则新建目录
                        if (!new File(pathRoot + "/static/images/").isDirectory()) {
                            new File(pathRoot + "/static/images/").mkdirs();
                        }
                        mf.transferTo(new File(pathRoot + path));
                        if (i == 1) {
                            record.setGphotourl1(path);
                            i++;
                        } else if (i == 2) {
                            record.setGphotourl2(path);
                            i++;
                        } else if (i == 3) {
                            record.setGphotourl3(path);
                            i++;
                        } else if (i == 4) {
                            record.setGphotourl4(path);
                            i++;
                        } else if (i == 5) {
                            record.setGphotourl5(path);
                            i++;
                        } else if (i == 6) {
                            record.setGphotourl6(path);
                            i++;
                        } else if (i == 7) {
                            record.setGphotourl7(path);
                            i++;
                        } else if (i == 8) {
                            record.setGphotourl8(path);
                            i++;
                        } else if (i == 9) {
                            record.setGphotourl9(path);
                            i++;
                        } else if (i == 10) {
                            record.setGphotourl10(path);
                            System.gc();
                        }
                    }else {
                        request.setAttribute("currency","添加失败 请上传图片");
                        return false;
                    }
                }
            }
        }

       int insert =  goodsInfoMapper.insert(record);
        request.setAttribute("currency","添加成功");
        return true;
    }

    @Override
    public int deleteByPrimaryKey(GoodsInfo record) {
        record.setStatus(0);
       int delete =  goodsInfoMapper.deleteByPrimaryKey(record);
        return delete;
    }

    /**
     * 发布商品前确认实名认证
     * @param httpSession
     * @return
     */
    @Override
    public Boolean RealName(HttpSession httpSession) {
        Person person = (Person) httpSession.getAttribute("user");
        RealName realName = realNameMapper.getRealNameByPrimaryKey(person.getId());
        if (realName!=null){
            return true;
        }
        return false;
    }

    /**
     * 锁商品
     * @param gId
     * @return
     */
    @Override
    public String seckillGoods(long gId,HttpSession httpSession) throws InterruptedException {
        //查询商品是否存在
        GoodsInfo goodsInfo = goodsInfoMapper.getGoodsById(gId);
        //查询下单用户是否实名认证
        Person person = (Person) httpSession.getAttribute("user");
        RealName realName = realNameMapper.getRealNameByPrimaryKey(person.getId());
        if (realName==null){
            return "noRealName";
        }
        //查询下单用户是否缴纳押金
        Deposit deposit = depositMapper.getDepositByPrimaryKey(person.getId());
        if (deposit==null){
            //缴纳押金

            //支付环节
            try{

                //成功存数据库
                depositMapper.insert(deposit);
            }catch (Exception e){
                e.printStackTrace();
            }

        }
        //判断商品是否被购买
        if (goodsInfo.getStatus() != 1) {
            //被购买返回false
            return "noGoods";
        }
        //获取id
        long id = goodsInfo.getgId();
        //判断是否被上锁 上锁返回false
        if (ResourceLock.tryLock(id)) {
            //上锁
            ResourceLock.accquireWrite(id);
            try {
                System.out.println("等待付款");
                Thread.sleep(30000);
                System.out.println("付款成功");
                goodsInfo.setStatus(0);
                //更改状态
                goodsInfoMapper.updateByPrimaryKey(goodsInfo);
                //解锁
                ResourceLock.releaseWrite(id);
                //支付成功 返回true
                return "success";
            } finally {
                //如果异常 解锁
                ResourceLock.releaseWrite(id);
                return "noseckillGoods";
            }
        }
        return "noseckillGoods";
    }

}

