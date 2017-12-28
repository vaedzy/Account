package com.account.common.utils;

import com.account.bean.AppQu;

import java.util.ArrayList;
import java.util.List;

public class AppQuUtil {
    private List<AppQu> getParentAll(List<AppQu> list,AppQu qu){
        List<AppQu> list1=new ArrayList<>();
        for (AppQu a:list) {
            if((a.getQuId())==(qu.getParentId())){
                list1.add(a);
                list1.addAll(getParentAll(list,a));
            }
        }
        return list1;
    }

    public List<AppQu> getQu(List<AppQu> list,AppQu qu){
        return getParentAll(list,qu);
    }

}
