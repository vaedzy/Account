package com.account.common.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.Serializable;
import java.util.List;

/**
 * 基于jackson实现的json转化
 *
 * @author dong
 * @date 2017/11/2
 */
public class JsonUtil {
    /**
     * JSON字符传转为List
     *
     * @param json
     * @return
     */
    public static <T extends Serializable> List<T> convert2List(String json, TypeReference<List<T>> typeReference) {
        if (json != null && json.trim().length() > 0) {
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                return objectMapper.readValue(json, typeReference);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * JSON字符传转为对象
     *
     * @param json
     * @return
     */
    public static <T extends Serializable> T convert2Object(String json, Class<T> clazz) {
        if (json != null && json.trim().length() > 0) {
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                return objectMapper.readValue(json, clazz);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
