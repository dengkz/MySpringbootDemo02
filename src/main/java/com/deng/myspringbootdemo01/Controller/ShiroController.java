package com.deng.myspringbootdemo01.Controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import org.apache.shiro.subject.Subject;

@Controller
public class ShiroController {

    @ResponseBody
    @RequestMapping("/shiro")
    public String shiro(){
        return "shiro";
    }


    @RequestMapping("/tologin")
    public String tologin(){
        return "/error/login";
    }

    @RequestMapping("/login")
    public String login(String username, String password, Model model){

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken userToken = new UsernamePasswordToken(username,password);

        try{
            subject.login(userToken);
            return "index";
        }catch (UnknownAccountException ex){
            model.addAttribute("msg","用户名或密码不正确");
            return "/error/login";
        }
    }

    @ResponseBody
    @RequestMapping("/unauth")
    public String unauth(){
        return "未授权";
    }

}
