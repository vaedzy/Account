package com.account.common.constant;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期类常量
 * @author donggb
 * @date 2017/10/28
 */
public class DateConsts {
    /**
     * 时区
     */
    public static final String TIME_ZERO="GMT+8";
    /**
     * 短字符串类型
     */
    public static final String DATE_PATTERN="yyyy-MM-dd";
    /**
     * 长字符串类型
     */
    public static final String TIME_PATTERN="yyyy-MM-dd HH:mm:ss";
    public static final DateFormat DATE_FORMAT=new SimpleDateFormat(DATE_PATTERN);
    public static final DateFormat TIME_FORMAT=new SimpleDateFormat(TIME_PATTERN);
    private DateConsts(){
        super();
    }



}
