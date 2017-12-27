package com.account.mapper;

import com.account.bean.AppType;

import java.util.List;

public interface AppTypeMapper {
    List<AppType> selectAll(String AppName);
}
