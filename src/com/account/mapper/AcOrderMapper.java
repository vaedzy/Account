package com.account.mapper;

import com.account.bean.AcOrder;
import com.account.bean.Person;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AcOrderMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AcOrder record);

    AcOrder selectByPrimaryKey(Long id);

    List<AcOrder> selectAll();

    int updateByPrimaryKey(AcOrder record);

    /**
     * 根据证件号查询当天订单信息
     *
     * @param userCode 证件号
     * @return
     */
    AcOrder getLastOrderNow(@Param("userCode") String userCode);
}