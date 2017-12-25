package com.account.common.utils;

import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.compile;

/**
 * 字符串工具类
 *
 * @author donggb
 * @date 2017/12/13
 */
public class StringUtil {
    /**
     * 判断字符串是否为空 null和“”全部返回真,否则返回假
     *
     * @param str 需要判断的字符串
     * @return
     */
    public static boolean isBlank(String str) {
        return str == null || str.length() == 0;
    }

    /**
     * 检查字符串是否全部是数字
     *
     * @param str
     * @return
     */
    public static boolean isNumber(String str) {
        Pattern p = compile("[0-9]+");
        Matcher matcher = p.matcher(str);
        return matcher.matches();
    }

    /**
     * 检查字符串是否包含指定字符串,正则表达式
     *
     * @param str
     * @param regex
     * @return
     */
    public static boolean containsSubStr(String str, String regex) {
        Pattern p = compile(regex);
        Matcher matcher = p.matcher(str);
        while (matcher.find()) {
            return true;
        }
        return false;
    }

    /**
     * 将字符串数组以指定符号连接，例["a","b"],指定链接符 ","返回字符串"a,b"
     *
     * @param strs 字符串数组
     * @param mark
     * @return 连接串
     */
    public static String join(String[] strs, String mark) {
        StringBuffer result = new StringBuffer();
        if (strs != null && strs.length > 0) {
            for (int i = 0; i < strs.length; i++) {
                result.append(strs[i]);
                if (i < strs.length - 1) {
                    result.append(mark);
                }
            }
        }
        return result.toString();
    }

    /**
     * 将数组以指定符号连接，例["a","b"],指定链接符 ","返回字符串"a,b"
     *
     * @param strs 字符串数组
     * @param mark
     * @return 连接串
     */
    public static String join(Object[] strs, String mark) {
        StringBuffer result = new StringBuffer();
        if (strs != null && strs.length > 0) {
            for (int i = 0; i < strs.length; i++) {
                result.append(strs[i]);
                if (i < strs.length - 1) {
                    result.append(mark);
                }
            }
        }
        return result.toString();
    }

    /**
     * 将List以指定符号连接，例["a","b"],指定链接符 ","返回字符串"a,b"
     *
     * @param objs 字符串数组
     * @param mark
     * @return 连接串
     */
    public static String join(List<Object> objs, String mark) {
        StringBuffer result = new StringBuffer();
        if (objs != null) {
            for (int i = 0; i < objs.size(); i++) {
                result.append(objs.get(i));
                if (i < objs.size() - 1) {
                    result.append(mark);
                }
            }
        }
        return result.toString();
    }

}
