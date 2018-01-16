package com.account.common.test;

import com.account.common.utils.DateUtil;

public class DateTest {
    public static void main(String [] args){
        System.out.println(DateUtil.isInTime("10:00-12:00","11:00"));
    }
}
