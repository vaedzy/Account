package com.account.mapper;

import com.account.bean.App;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AppMapper {

    List<App> getAll(@Param("aAppIndex") String aAppIndex);
}

