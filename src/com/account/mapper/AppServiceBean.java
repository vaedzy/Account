package com.account.mapper;

import java.util.List;

public interface AppServiceBean {

    public List<AppDetails> selectApp(long AppParentId);
}
