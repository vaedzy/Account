package com.account.mapper;

import com.account.bean.AppDeveloper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AppDeveloperMapper {
    /**
     * 插入
     * @param record
     * @return
     */
    int insert(AppDeveloper record);

    /**
     * 查询
     * @param appDeveloper
     * @return
     */
    AppDeveloper selectByAppDeveloper(@Param("appDeveloper")String appDeveloper);

    /**
     * 查询所有
     * @return
     */
    List<AppDeveloper> selectAll();

    /**
     * 删除
     * @param id
     * @return
     */
    int deleteByPrimaryKey(@Param("id") long id);
}
