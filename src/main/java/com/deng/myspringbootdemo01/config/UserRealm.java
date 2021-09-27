package com.deng.myspringbootdemo01.config;


import com.deng.myspringbootdemo01.model.UserDomain;
import com.deng.myspringbootdemo01.service.user.UserService;
import org.apache.catalina.security.SecurityUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRealm extends AuthorizingRealm {


    @Autowired
    UserService userService;

    // 授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        System.out.println("执行了授权");

        //授权
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        //simpleAuthorizationInfo.addStringPermission("user:add");

        Subject subject = SecurityUtils.getSubject();
        UserDomain userDomain = (UserDomain)subject.getPrincipal();


        simpleAuthorizationInfo.addStringPermission(userDomain.getPerm());

        return simpleAuthorizationInfo;
    }


    // 认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("执行了认证");

        UsernamePasswordToken userToken = (UsernamePasswordToken)token;
        //连接数据库
        UserDomain user = userService.getUserByName(userToken.getUsername());
        if(user==null){
            return  null;
        }




        return new SimpleAuthenticationInfo(user,user.getPwd(),"");
    }
}
