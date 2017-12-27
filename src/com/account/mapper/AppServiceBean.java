package com.account.mapper;

import com.account.bean.AppDetails;

import java.util.List;

public interface AppServiceBean {

    public List<AppDetails> selectApp(long AppParentId);
}
