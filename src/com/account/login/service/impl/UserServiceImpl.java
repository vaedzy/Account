package com.account.login.service.impl;

import com.account.bean.Person;
import com.account.bean.RealName;
import com.account.common.constant.SystemConstant;
import com.account.common.utils.IpUtil;
import com.account.login.service.UserService;
import com.account.mapper.PersonMapper;
import com.account.mapper.RealNameMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service("userService")
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService{
    @Autowired(required = false)
    private PersonMapper personMapper;
    @Autowired(required = false)
    private RealNameMapper realNameMapper;
    /**
     * 通过手机号查找人员，
     * 如果该人员不存在则自动保存改手机号信息
     * @param phone
     * @return
     */
    @Override
    public Person getUser(String phone, HttpServletRequest request)  {
        Person person = personMapper.getPersonByPhone(phone);
        if (person ==null){
            person = new Person();
            person.setpPhone(phone);
            person.setpIsRegistered(SystemConstant.NO);
            personMapper.insert(person);
        }
        person.setpLastIp(IpUtil.getIpAddr(request));
        person.setpLastTime(new Date());
        personMapper.updateByPrimaryKey(person);
        return person;
    }

    /**
     * 更新人员信息
     * @param user
     * @return
     */
    @Override
    public Person updatePerson(Person user, HttpServletRequest request){
        Person person = personMapper.getPersonByPhone(user.getpPhone());
        //最后登录信息
        person.setpLastTime(new Date());
        person.setpLastIp(IpUtil.getIpAddr(request));
        person.setpRegisteredIp(IpUtil.getIpAddr(request));
        person.setpRegisteredTime(new Date());
        //引入注册信息（暂时的是用户名）
        person.setpFullname(user.getpFullname());
        //已经注册
        person.setpIsRegistered(SystemConstant.YES);
        personMapper.updateByPrimaryKey(person);
        return user;
    }

    /**
     * 实名认证
     * @param realName
     * @param file
     * @param request
     * @return
     * @throws Exception
     */
    @Override
    public String insertRealName(RealName realName, MultipartFile[] file, HttpServletRequest request)  throws Exception {
        List<String> fileTypes = new ArrayList<String>();
        fileTypes.add("jpg");
        fileTypes.add("jpeg");
        fileTypes.add("bmp");
        fileTypes.add("png");
        if (file != null) {
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
                    String imageName = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());
                    imageName = imageName.toLowerCase();
                    if (fileTypes.contains(imageName)) {
                        path = "/static/images/" + uuid + "." + imageName;
                        //如果没有该目录则新建目录
                        if (!new File(pathRoot + "/static/images/").isDirectory()) {
                            new File(pathRoot + "/static/images/").mkdirs();
                        }
                        mf.transferTo(new File(pathRoot + path));
                        if (i == 1) {
                            realName.setIdCardUrl1(path);
                            i++;
                        } else if (i == 2) {
                            realName.setIdCardUrl2(path);
                            i++;
                        }
                    }
                }
            }
            int ok = realNameMapper.insert(realName);
            if (ok == 1) {
                return "success";
            }
            return "error";
        }
        return "error";
    }

    /**
     * 查询实名认证
     * @param httpSession
     * @param id
     * @return
     */
    @Override
    public String selectRealName(HttpSession httpSession, long id) {
        if (realNameMapper.getRealNameByPrimaryKey(id)!=null){
            return "success";
        }
        return "noRealName";
    }


}
