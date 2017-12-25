package com.account.login.service.impl;

import com.account.bean.Person;
import com.account.common.constant.SystemConstant;
import com.account.common.utils.IpUtil;
import com.account.login.service.UserService;
import com.account.mapper.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Service("userService")
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService{
    @Autowired(required = false)
    private PersonMapper personMapper;
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


}
