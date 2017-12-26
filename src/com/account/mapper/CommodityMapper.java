package com.account.mapper;

import com.account.bean.Commodity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommodityMapper {
    List<Commodity> selectAll(@Param("AppName")String AppName);
}
