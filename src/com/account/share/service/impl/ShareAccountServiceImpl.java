package com.account.share.service.impl;

import com.account.bean.AppDeveloper;
import com.account.mapper.AppDeveloperMapper;
import com.account.share.service.ShareAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShareAccountServiceImpl implements ShareAccountService{

    @Autowired
    private AppDeveloperMapper appDeveloperMapper;
    @Override
    public AppDeveloper ControlAccount(String appDeveloper) {

        return appDeveloperMapper.selectByAppDeveloper(appDeveloper);
    }

    @Override
    public void insertAccount(AppDeveloper appDeveloper) {
        appDeveloperMapper.insert(appDeveloper);
    }

    @Override
    public void deleteAccount(long id) {
        appDeveloperMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<AppDeveloper> appDeveloperList() {
        List<AppDeveloper> appDeveloperList = appDeveloperMapper.selectAll();
        return appDeveloperList;
    }

}
