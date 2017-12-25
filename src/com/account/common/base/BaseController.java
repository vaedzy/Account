package com.account.common.base;

import com.account.bean.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * controller 父类
 * @author 董广斌
 * @date 2017/12/25
 * @time 10:40
 */
public class BaseController {

    private static final Logger log= LoggerFactory.getLogger(BaseController.class);

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.setFieldDefaultPrefix("entity.");
    }

    /**
     * 通过session 获取当前登录信息
     * @return
     */
    public Person getUser() {
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes) ra)
                .getRequest();
        return (Person) request.getSession().getAttribute("user_info");
    }
}
