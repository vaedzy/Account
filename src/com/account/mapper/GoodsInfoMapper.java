package com.account.mapper;

import com.account.bean.GoodsInfo;


import java.util.List;

public interface GoodsInfoMapper {
    List<GoodsInfo> getGoodsByAppId(long AppId);
    List<GoodsInfo> getByName();
    GoodsInfo getGoodsById(long gId);
    int updateByPrimaryKey(GoodsInfo record);
    int insert(GoodsInfo record);
    int deleteByPrimaryKey(GoodsInfo record);
}
