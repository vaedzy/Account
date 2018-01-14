package com.account.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * 日期工具类
 *
 * @author yin
 * @date 2017/11/22
 */
public class DateUtil {
    private static final Logger log= LoggerFactory.getLogger(DateUtil.class);
    /**
     * 中国以周一为每周的第一天
     */
    private static final int FIRST_DAY_OF_WEEK = Calendar.MONDAY;
    /**
     * 一周的天数
     */
    private static long WEEK_DAY_NUMBER = 7;


    /**
     * 获取当前毫秒值
     *
     * @return
     */
    public static Long getMillisecond() {
        return System.currentTimeMillis();
    }

    /**
     * 获取指定日期为当月第几天
     *
     * @param date Date 指定日期
     * @return 当月第几天
     */
    public static int getDayOfMonth(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int day = c.get(Calendar.DAY_OF_MONTH);
        return day;
    }

    /**
     * 获取指定日期为当年第几天
     *
     * @param date Date 指定日期
     * @return 当年第几天
     */
    public static int getDayOfYear(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int day = c.get(Calendar.DAY_OF_YEAR);
        return day;
    }


    /**
     * 将日期转化为字符型日期字符串
     * "yyyy-MM-dd HH:mm:ss"
     *
     * @param date
     * @param params 日期格式
     * @return
     */
    public static String formatIntToDateString(Date date, String params) {
        String str= "";
        if (date != null) {
            try {
                DateFormat format = new SimpleDateFormat(params, Locale
                        .getDefault());
                str = format.format(date);
            } catch (Exception ex) {
                log.error("日期转换失败",ex);
            }
        }
        return str;
    }

    /**
     * 返回指定日期月份
     *
     * @param date Date 指定日期
     * @return 月份
     */

    public static int getMonth(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int day = c.get(Calendar.MONTH);
        return day + 1;
    }

    /**
     * 返回指定日期年份
     *
     * @param date Date 指定日期
     * @return 年份
     */
    public static int getYear(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int day = c.get(Calendar.YEAR);
        return day + 1;
    }

    /**
     * 返回指定日期所属月份天数
     *
     * @param date Date 指定日期
     * @return 天数
     */
    public static int getDayNumberOfMonth(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    /**
     * 返回指定日期所属年天数
     *
     * @param date Date 指定日期
     * @return 天数
     */
    public static int getDayNumberOfYear(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.getActualMaximum(Calendar.DAY_OF_YEAR);
    }

    /**
     * 返回指定日期星期几（0代表周日）
     *
     * @param date Date 指定日期
     * @return 星期几
     */
    public static int getDayOfWeek(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
        return dayOfWeek - 1;
    }

    /**
     * 返回指定日期所在周的周一
     *
     * @param date Date 指定日期
     * @return 指定日期所在周的周一
     */
    public static Date getMondayOfWeek(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.setFirstDayOfWeek(FIRST_DAY_OF_WEEK);
        c.set(Calendar.DAY_OF_YEAR, Calendar.MONDAY);
        return c.getTime();
    }


    /**
     * 返回指定日期所在周的周一
     *
     * @param date Date 指定日期
     * @return 指定日期所在周的周日
     */
    public static Date getSundayOfWeek(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.setFirstDayOfWeek(FIRST_DAY_OF_WEEK);
        c.set(Calendar.DAY_OF_YEAR, Calendar.SUNDAY);
        return c.getTime();
    }

    /**
     * 返回指定日期所在月第一天
     *
     * @param date Date 指定日期
     * @return 所在月第一天
     */
    public static Date getFirstDayOfMonth(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.DAY_OF_MONTH, c.getActualMinimum(Calendar.DAY_OF_MONTH));
        return c.getTime();
    }

    /**
     * 返回指定日期所在月最后一天
     *
     * @param date Date 指定日期
     * @return 所在月最后一天
     */
    public static Date getLastDayOfMonth(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
        return c.getTime();
    }

    /**
     * 取得指定日期所属季度 1 第一季度 2 第二季度 3 第三季度 4 第四季度
     *
     * @return 1, 第一季度;2,第二季度;3,第三季度;4,第四季度
     */
    public static int getQuarter(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int season = 0;
        int month = c.get(Calendar.MONTH);
        switch (month) {
            case Calendar.JANUARY:
            case Calendar.FEBRUARY:
            case Calendar.MARCH:
                season = 1;
                break;
            case Calendar.APRIL:
            case Calendar.MAY:
            case Calendar.JUNE:
                season = 2;
                break;
            case Calendar.JULY:
            case Calendar.AUGUST:
            case Calendar.SEPTEMBER:
                season = 3;
                break;
            case Calendar.OCTOBER:
            case Calendar.NOVEMBER:
            case Calendar.DECEMBER:
                season = 4;
                break;
            default:
                break;
        }
        return season;
    }

    /**
     * 为给定的日期添加或减去指定的天数
     *
     * @param date Date 指定日期
     * @param n    int 加减天数
     * @return
     */
    public static Date addDate(Date date, int n) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DAY_OF_MONTH, n);
        return c.getTime();
    }

    /**
     * 两个日期的间隔小时数
     *
     * @param begin Date 开始日期
     * @param end   Date 结束日期
     * @return 间隔小时数
     */
    public static long getIntervalHour(Date begin, Date end) {
        long num = 0L;
        if (begin != null && end != null) {
            num = (begin.getTime() - end.getTime()) / (1000 * 60 * 60);
        }
        return num;
    }

    /**
     * 两个日期的间隔天数
     *
     * @param begin Date 开始日期
     * @param end   Date 结束日期
     * @return long 两天的间隔天数
     */
    public static long getIntervalDate(Date begin, Date end) {
        long num = 0L;
        if (begin != null && end != null) {
            num = (begin.getTime() - end.getTime()) / (1000 * 60 * 60 * 24);
        }
        return num;
    }

    /**
     * 计算两个日期相差的周数
     *
     * @param begin Date 开始日期
     * @param end   Date 结束日期
     * @return long 相差的周数
     */
    public static long getIntervalWeeks(Date begin, Date end) {
        if (begin == null || end == null) {
            return 0;
        }
        long days = getIntervalDate(begin, end);
        long quotient = days / WEEK_DAY_NUMBER;
        if (days % WEEK_DAY_NUMBER > 0) {
            quotient++;
        }
        return quotient;
    }
}
