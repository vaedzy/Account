package com.account.mapper;

import com.account.bean.Person;
import java.util.List;

public interface PersonDao {
    int insert(Person record);

    List<Person> selectAll();
}