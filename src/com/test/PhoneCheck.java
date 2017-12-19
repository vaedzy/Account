package com.test;

import com.account.common.utils.PhoneFormatCheckUtils;
import org.junit.Test;

public class PhoneCheck {
    @Test
    public void demo(){
        System.out.println(PhoneFormatCheckUtils.isChinaPhoneLegal("13241997744"));
    }
}
