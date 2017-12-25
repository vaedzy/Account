package com.account.common.utils;

import org.springframework.cglib.beans.BeanMap;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 董广斌
 * @date 2017/12/12
 * @time 10:22
 */
public class MapUtil {

    /**
     * 将 bean 对象转换成Map
     *
     * @param bean
     * @return
     */
    public static <T> Map<String, Object> beanToMap(T bean) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (bean != null) {
            BeanMap beanMap = BeanMap.create(bean);
            for (Object key : beanMap.keySet()) {
                map.put(key + "", beanMap.get(key));
            }
        }
        return map;
    }

    /**
     * 将 beanList 对象转换成List<Map>
     *
     * @param beanList
     * @return
     */
    public static <T> List<Map<String, Object>> beanListToListMap(List<T> beanList) {
        List<Map<String, Object>> listMap = new ArrayList<>();
        if (beanList != null) {
            for (T bean : beanList) {
                Map<String, Object> map = new HashMap<String, Object>();
                BeanMap beanMap = BeanMap.create(bean);
                for (Object key : beanMap.keySet()) {
                    map.put(key + "", beanMap.get(key));
                }
                listMap.add(map);
            }
        }
        return listMap;
    }

    /**
     * 将map 转换成指定的bean对象
     *
     * @param map
     * @param bean
     * @param <T>
     * @return
     */
    public static <T> T mapToBean(Map<String, Object> map, T bean) {
        BeanMap beanMap = BeanMap.create(bean);
        beanMap.putAll(map);
        return bean;
    }

    /**
     * 将beanlist中对象的某一个属性作为key ，
     * 另一个属性作为 value封装到map 中
     *
     * @param beanList
     * @param key
     * @param value
     * @param <T>
     * @return
     */
    public static <T> Map beanListToMap(List<T> beanList, String key, String value) {

        Map<Object, Object> map = new HashMap<>();
        try {
            for (T bean : beanList) {
                Field keyField = bean.getClass().getDeclaredField(key);
                Field valueField = bean.getClass().getDeclaredField(value);
                keyField.setAccessible(true);
                valueField.setAccessible(true);
                map.put(keyField.get(bean), valueField.get(bean));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }
}
