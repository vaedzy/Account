package com.account.mapper;

import com.account.bean.GoodsInfo;

import java.util.List;

public interface GoodsInfoMapper {
    public List<GoodsInfo> getGoodsByAppId(long AppId);
    public List<GoodsInfo> getByName();
}
