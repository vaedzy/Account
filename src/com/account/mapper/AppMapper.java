package com.account.mapper;

import com.account.bean.App;
import java.util.List;

public interface AppMapper {

    List<App> getAll(String aAppIndex);
}