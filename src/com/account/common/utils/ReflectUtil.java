package com.account.common.utils;

import com.account.bean.Person;

import java.lang.reflect.Field;
import java.util.Date;

/**
 * 反射工具类
 *
 * @author yin
 * @date 2017/10/25
 */
public class ReflectUtil {


    /**
     * 获取属性
     *
     * @param obj
     * @param fieldName
     * @return
     */
    public static Field getFieldByFieldName(Object obj, String fieldName) {
        for (Class<?> superClass = obj.getClass(); superClass != Object.class; superClass = superClass.getSuperclass()) {
            try {
                return superClass.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
            }
        }
        return null;
    }

    /**
     * Obj fieldName的获取属性值.
     *
     * @param obj
     * @param fieldName
     * @return
     * @throws SecurityException
     * @throws NoSuchFieldException
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     */
    public static Object getValueByFieldName(Object obj, String fieldName) throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        Field field = getFieldByFieldName(obj, fieldName);
        Object value = null;
        if (field != null) {
            if (field.isAccessible()) {
                value = field.get(obj);
            } else {
                field.setAccessible(true);
                value = field.get(obj);
                field.setAccessible(false);
            }
        }
        return value;
    }

    /**
     * obj fieldName设置的属性值.
     *
     * @param obj
     * @param fieldName
     * @param value
     * @throws SecurityException
     * @throws NoSuchFieldException
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     */
    public static void setValueByFieldName(Object obj, String fieldName, Object value) throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        Field field = obj.getClass().getDeclaredField(fieldName);
        if (field.isAccessible()) {
            field.set(obj, value);
        } else {
            field.setAccessible(true);
            field.set(obj, value);
            field.setAccessible(false);
        }
    }

    /**
     * 赋值 默认属性  ： 创建人， 创建时间， 修改人，修改时间 。
     *
     * @param obj
     * @param personnelInformation
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    public static Object setDefaultAttrbute(Object obj, Person personnelInformation) {

        Class<?> aClass = obj.getClass();

        try {
            Field createTime = aClass.getDeclaredField("createTime");
            Field creator = aClass.getDeclaredField("creator");
            Field modifyTime = aClass.getDeclaredField("modifyTime");
            Field modifier = aClass.getDeclaredField("modifier");
            if (!createTime.isAccessible()) {
                createTime.setAccessible(true);
                if (createTime.get(obj) == null) {
                    createTime.set(obj, new Date());
                    creator.setAccessible(true);
                    creator.set(obj, personnelInformation.getpPhone());
                    creator.setAccessible(false);
                }
                createTime.setAccessible(false);
            }
            if (!modifyTime.isAccessible()) {
                modifyTime.setAccessible(true);
                modifier.setAccessible(true);
                modifyTime.set(obj, new Date());
                modifier.set(obj, personnelInformation.getpPhone());
                modifyTime.setAccessible(false);
                modifier.setAccessible(false);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return obj;
    }
}
