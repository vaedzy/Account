package com.account.common.utils;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

/**
 * 拼音工具类
 * @author yin
 * @date 2017/12/13
 */
public class PinyinUtil {


    /**
     * 汉字转换成拼音（返回值大写）
     *
     * @param str   汉字
     * @param spera 间隔符
     * @return
     * @throws BadHanyuPinyinOutputFormatCombination
     */
    public static String toPinYinFormatUpperCase(String str, String spera) throws BadHanyuPinyinOutputFormatCombination {
        return toPinYin(str, spera, Type.UPPERCASE);
    }

    /**
     * 汉字转换成拼音（返回值小写）
     *
     * @param str   汉字
     * @param spera 间隔符
     * @return
     * @throws BadHanyuPinyinOutputFormatCombination
     */
    public static String toPinYinFormatLowerCase(String str, String spera) throws BadHanyuPinyinOutputFormatCombination {
        return toPinYin(str, spera, Type.LOWERCASE);
    }

    /**
     * 汉字转换成拼音（返回值首字母大写）
     *
     * @param str   汉字
     * @param spera 间隔符
     * @return
     * @throws BadHanyuPinyinOutputFormatCombination
     */
    public static String toPinYinFormatFirstUpper(String str, String spera) throws BadHanyuPinyinOutputFormatCombination {
        return toPinYin(str, spera, Type.FIRSTUPPER);
    }

    public static String toPinYin(String str, String spera, Type type) throws BadHanyuPinyinOutputFormatCombination {

        HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
        //不带数字 ， 及拼音
        format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);

        switch (type) {
            case LOWERCASE:
                format.setCaseType(HanyuPinyinCaseType.LOWERCASE);
                break;
            case UPPERCASE:
                format.setCaseType(HanyuPinyinCaseType.UPPERCASE);
                break;
             default:
                 break;
        }

        if (StringUtil.isBlank(str)) {
            return "";
        }
        String pinYi = "";
        String temp = "";
        String[] t;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if ((int) c <= 128) {
                pinYi += c;
            } else {
                t = PinyinHelper.toHanyuPinyinStringArray(c, format);
                if (t == null) {
                    pinYi += c;
                } else {
                    temp = t[0];
                    if (Type.FIRSTUPPER.equals(type)) {
                        temp = t[0].toUpperCase().charAt(0) + temp.substring(1);
                    }
                    pinYi += temp + (i == str.length() - 1 ? "" : spera);
                }
            }
        }

        return pinYi.trim();
    }

    public enum Type {
        /**
         * 全部大写
         */
        UPPERCASE,
        /**
         * 全部小写
         */
        LOWERCASE,
        /**
         * 首字母大写
         */
        FIRSTUPPER
    }
}
