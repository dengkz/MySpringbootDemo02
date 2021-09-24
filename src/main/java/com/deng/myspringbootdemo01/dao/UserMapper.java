package com.deng.myspringbootdemo01.dao;

import com.deng.myspringbootdemo01.model.UserDomain;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    List<UserDomain> getAllUser();
    //String getUserByName(String name);
}
