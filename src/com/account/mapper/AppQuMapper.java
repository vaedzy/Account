package com.account.mapper;


import com.account.bean.AppQu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AppQuMapper {
    List<AppQu> getAppQu(@Param("AppId") long AppId);
    List<AppQu> getAppQuName(@Param("QuName")String quName);
}
