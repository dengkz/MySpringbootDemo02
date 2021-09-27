package com.deng.myspringbootdemo01.service.user.impl;

import com.deng.myspringbootdemo01.dao.UserMapper;
import com.deng.myspringbootdemo01.model.UserDomain;
import com.deng.myspringbootdemo01.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceimpl  implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<UserDomain> getAllUser() {
        List<UserDomain> list = userMapper.getAllUser();

        return list;
    }


    @Override
    public UserDomain getUserByName(String name) {

        UserDomain userDomain = userMapper.getUserByName(name);
        return userDomain;
    }
}
