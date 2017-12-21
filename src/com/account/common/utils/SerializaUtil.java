package com.account.common.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializaUtil {
    public static byte[] seriazlize(Object object){
        ObjectOutputStream objectOutputStream = null;
        ByteArrayOutputStream byteArrayOutputStream = null;
        try{
            //序列化
            byteArrayOutputStream = new ByteArrayOutputStream();
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(object);
            byte [] bytes = byteArrayOutputStream.toByteArray();
            return bytes;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static Object unserialize(byte[] bytes){
        if (bytes == null)
                return null;
        ByteArrayInputStream byteArrayInputStream = null;
        try{
            //反序列化
            byteArrayInputStream = new ByteArrayInputStream(bytes);
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            return objectInputStream.readObject();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
