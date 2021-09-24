package com.deng.myspringbootdemo01.service.user;


import com.deng.myspringbootdemo01.model.UserDomain;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    List<UserDomain> getAllUser();
    //String getUserByName(String name);
}
