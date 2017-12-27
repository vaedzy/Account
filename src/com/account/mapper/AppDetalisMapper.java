package com.account.mapper;

import com.account.bean.AppDetails;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AppDetalisMapper {
    List<AppDetails> selectAll(@Param("AppName")String AppName);
    public AppDetails select(long id);
}
