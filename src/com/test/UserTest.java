package com.test;


import com.account.bean.User;
import com.account.mapper.UserDao;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserTest{
private ApplicationContext applicationContext;

@Before
public void setUp() throws Exception {
    applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
}
    @Test
    public void testGetUserById() {
        UserDao userDao = (UserDao) applicationContext.getBean("userDao");
        User user = new User("13241997744");

        User user1 = userDao.findUser(user);
        System.out.println(user1.getPhone());

    }
}