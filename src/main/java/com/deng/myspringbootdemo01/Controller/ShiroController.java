package com.deng.myspringbootdemo01.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ShiroController {

    @ResponseBody
    @RequestMapping("/shiro")
    public String shiro(){


        return "shiro";
    }


}
