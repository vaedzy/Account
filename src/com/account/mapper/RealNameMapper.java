package com.account.mapper;

import com.account.bean.RealName;

public interface RealNameMapper {
    int insert (RealName record);
    RealName getRealNameByPrimaryKey(Long id);
}
