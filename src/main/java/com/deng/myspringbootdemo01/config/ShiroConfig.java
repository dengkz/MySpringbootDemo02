package com.deng.myspringbootdemo01.config;


import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    // 3
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(@Qualifier("getDefaultWebSecurityManager")DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();

        //设置安全管理器
        bean.setSecurityManager(defaultWebSecurityManager);

        /**
         * anon 无需认证就可访问
         * authc 必须认证才能访问
         * user
         * perms 拥有某个资源权限才能访问
         * role拥有某个角色权限才能访问
         */

        // 拦截
        Map<String, String> shiroFilter = new LinkedHashMap<String, String>();
        shiroFilter.put("/index","anon");
        shiroFilter.put("/unauth","anon");
        shiroFilter.put("/login","anon");
        shiroFilter.put("/tologin","anon");

        shiroFilter.put("/jdbc","perms[user:add]");
        shiroFilter.put("/*","authc");

        bean.setFilterChainDefinitionMap(shiroFilter);

        bean.setLoginUrl("/tologin");
        bean.setUnauthorizedUrl("/unauth");
        bean.setSuccessUrl("/index");
        return bean;
    }

    // 2
    @Bean
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();

        //关联userRealm
        defaultWebSecurityManager.setRealm(userRealm);

        return  defaultWebSecurityManager;
    }

    //1 创建Realm
    @Bean
    public UserRealm userRealm(){
        return  new UserRealm();
    }

}
