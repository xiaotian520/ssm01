package com.xiaotian.ssm.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @RequestMapping("login")
    public String login(String username , String password , HttpSession session){
        if("xiaotian".equals(username) && "123".equals(password)){
            //登陆成功
            //1.保存session
            session.setAttribute("user",username);
            //2.进入主页main
            return "main";
        }
        return "login";
    }
}
