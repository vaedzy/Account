package com.account.mapper;

import com.account.bean.Person;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PersonMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Person record);

    Person getPersonByPrimaryKey(Long id);
    /**
     * 通过手机号查找人员
     * @param pPhone
     * @return
     */
    Person getPersonByPhone(@Param("pPhone") String  pPhone);

    List<Person> listPersons();

    int updateByPrimaryKey(Person record);
    int updateLogin(@Param("pPhone") String pPhone);
}