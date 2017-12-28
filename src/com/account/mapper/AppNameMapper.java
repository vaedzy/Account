package com.account.mapper;


import com.account.bean.AppName;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AppNameMapper {
    List<AppName> getAppName(@Param("search") String search);
}
