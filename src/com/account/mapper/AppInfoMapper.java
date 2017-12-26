package com.account.mapper;

import com.account.bean.AppInfo;

import java.util.List;

public interface AppInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AppInfo record);

    AppInfo selectByPrimaryKey(Long id);

    List<AppInfo> selectAll();

    int updateByPrimaryKey(AppInfo record);
}