package com.account.login.service.impl;

import com.account.bean.Person;
import com.account.login.service.UserService;
import com.account.mapper.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public Person getUser(String phone)  {
        Person person = personMapper.getPersonByPhone(phone);
        if (person ==null){
            person = new Person();
            person.setpPhone(phone);
            personMapper.insert(person);
        }
        return person;
    }

    /**
     * 更新人员信息
     * @param user
     * @return
     */
    @Override
    public Person updatePerson(Person user){
        personMapper.updateByPrimaryKey(user);
        return user;
    }
}
