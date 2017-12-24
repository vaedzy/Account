package com.account.mapper;


import com.account.bean.Person;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PersonMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Person record);

    /**
     * 通过主键查找人员
     * @param id
     * @return
     */
    Person getPersonByPrimaryKey(Integer id);

    /**
     * 通过手机号查找人员
     * @param phone
     * @return
     */
    Person getPersonByPhone(@Param("phone") String  phone);

    List<Person> listPersons();

    int updateByPrimaryKey(Person record);
}