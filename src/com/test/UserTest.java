package com.test;
import com.account.bean.User;
import com.account.login.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml"})
public class UserTest{
    @Autowired
    UserService userService;
    @Test
    public void TestUser(){
        User user = new User("13241997744");
        user =  userService.findUser(user);
        System.out.println(user.getId());
    }
}
