package com.account.mapper;

import com.account.bean.GoodsInfo;
import org.apache.ibatis.annotations.Param;


import java.util.List;

public interface GoodsInfoMapper {
    List<GoodsInfo> getGoodsByAppId(@Param("AppId") long AppId, @Param("startTime") String startTime);
    List<GoodsInfo> getGoodsInfoQu(@Param("quId") long quId,@Param("startTime") String startTime);
    GoodsInfo getGoodsById(long gId);
    int updateByPrimaryKey(GoodsInfo record);
    int insert(GoodsInfo record);
    int deleteByPrimaryKey(GoodsInfo record);
}
